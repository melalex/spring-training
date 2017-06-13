package ua.room414.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "api.character")
public class IceAndFireApiProperties {
    private String find;
    private String filter;
    private RouteParam routeParam = new RouteParam();

    @Setter
    @Getter
    public static class RouteParam {
        private String page;
        private String name;
        private String gender;
        private String culture;
        private String born;
        private String died;
        private String isAlive;
    }
}
