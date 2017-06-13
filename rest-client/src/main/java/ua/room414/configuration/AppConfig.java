package ua.room414.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Configuration
@PropertySource("classpath:filesIntegration.properties")
@EnableConfigurationProperties(IceAndFireApiProperties.class)
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
