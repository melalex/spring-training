package ua.room414.web.soap;

import org.apache.ws.commons.schema.resolver.DefaultURIResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

/**
 * @author Alexander Melashchenko
 * @version 1.0 02 Jun 2017
 */
@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "service")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection xsdSchemaCollection) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookingPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://ua/room414/service");
        wsdl11Definition.setSchemaCollection(xsdSchemaCollection);

        return wsdl11Definition;
    }

    @Bean
    public XsdSchemaCollection serviceSchema() {
        final CommonsXsdSchemaCollection result = new CommonsXsdSchemaCollection();
        result.setUriResolver(new DefaultURIResolver());
        result.setInline(true);

        result.setXsds(
                new ClassPathResource("service.xsd"),
                new ClassPathResource("service-dto.xsd"),
                new ClassPathResource("service-event.xsd"),
                new ClassPathResource("service-response.xsd"),
                new ClassPathResource("service-user.xsd")
        );

        return result;
    }
}
