package ua.room414;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * @author Alexander Melashchenko
 * @version 1.0 09 Jun 2017
 */
@Configuration
@PropertySource("classpath:filesIntegration.properties")
public class FilesIntegrationConfiguration {

    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileOutputChannel() {
        return new DirectChannel();
    }

    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource(
            @Value("${directory.path.input}") String inboundPath,
            @Value("${file.regexp}")String regexp
    ) {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File(inboundPath));
        source.setFilter(new RegexPatternFileListFilter(regexp));
        return source;
    }
}
