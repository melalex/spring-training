package ua.room414;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.context.IntegrationContextUtils;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.support.Function;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.support.MessageBuilder;

import java.io.File;

/**
 * @author Alexander Melashchenko
 * @version 1.0 09 Jun 2017
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan
@PropertySource("classpath:filesIntegration.properties")
public class FilesIntegrationConfiguration {
    public static final String FILE_WRITING_INPUT_CHANEL = "fileWritingInputChanel";
    public static final String FILE_WRITING_OUTPUT_CHANEL = "fileWritingOutputChanel";
    public static final String FILE_HANDLER_INPUT_CHANEL = "addFileNameToIdsChanel";
    public static final String DIRECTORY_PATH_HEADER = "directory";

    private static final long POLLERS_PERIOD = 1000;

    private FileIntegrationProperties properties;

    @Autowired
    public void setProperties(FileIntegrationProperties properties) {
        this.properties = properties;
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedDelay(POLLERS_PERIOD).get();
    }

    @Bean
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource source = new FileReadingMessageSource();

        source.setUseWatchService(true);
        source.setWatchEvents(FileReadingMessageSource.WatchEventType.CREATE);
        source.setDirectory(properties.getSource());
        source.setFilter(new RegexPatternFileListFilter(properties.getRegexp()));

        return source;
    }

    @Bean
    public MessageChannel fileWritingInputChanel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel addFileNameToIdsChanel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public IntegrationFlow fileReadingFlow() {
        return IntegrationFlows
                .from(fileReadingMessageSource())
                .transform(Transformers.fileToString())
                .publishSubscribeChannel(s -> s
                        .subscribe(f -> f
                                .enrichHeaders(h -> h
                                        .header(DIRECTORY_PATH_HEADER, properties.getProcessing()))
                                .channel(FILE_WRITING_INPUT_CHANEL))
                        .subscribe(f -> f
                                .enrichHeaders(h -> h
                                        .header(DIRECTORY_PATH_HEADER, properties.getComplete()))
                                .channel(FILE_HANDLER_INPUT_CHANEL)))
                .get();
    }

    @Bean
    public IntegrationFlow errorHandleFlow() {
        return IntegrationFlows
                .from(IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME)
                .log(LoggingHandler.Level.ERROR, errorMessageEvaluator())
                .transform(errorMessageTransformer())
                .channel(FILE_WRITING_INPUT_CHANEL)
                .get();
    }

    @Bean
    public Function<Message<MessageHandlingException>, Object> errorMessageEvaluator() {
        return m -> "Error while processing file " + m
                .getPayload()
                .getFailedMessage()
                .getHeaders()
                .get(FileHeaders.FILENAME);
    }

    @Bean
    public GenericTransformer<Message<MessageHandlingException>, Message<String>> errorMessageTransformer() {
        return m -> MessageBuilder
                .withPayload((String) m.getPayload().getFailedMessage().getPayload())
                .setHeader(FileHeaders.FILENAME, m.getPayload().getFailedMessage().getHeaders().get(FileHeaders.FILENAME))
                .setHeader(DIRECTORY_PATH_HEADER, properties.getError())
                .build();
    }

    @Bean
    public IntegrationFlow fileWritingFlow() {
        return IntegrationFlows
                .from(FILE_WRITING_INPUT_CHANEL)
                .handleWithAdapter(a -> a.fileGateway(m -> m.getHeaders().get(DIRECTORY_PATH_HEADER)))
                .channel(FILE_WRITING_OUTPUT_CHANEL)
                .get();
    }
}
