package ua.room414;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
@Configuration
@PropertySource("classpath:bookingService.properties")
public class BookingConfiguration {

    @Value("${booking.service.uri}")
    private String serviceUri;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("service.wsdl");

        return marshaller;
    }

    @Bean
    public BookingClient bookingClient(Jaxb2Marshaller marshaller) {
        BookingClient client = new BookingClient();

        client.setDefaultUri(serviceUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
