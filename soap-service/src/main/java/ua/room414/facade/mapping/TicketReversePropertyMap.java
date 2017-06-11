package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Ticket;
import ua.room414.dto.TicketDto;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Component
public class TicketReversePropertyMap extends PropertyMapConfigurerSupport<TicketDto, Ticket> {

    @Override
    public PropertyMap<TicketDto, Ticket> mapping() {
        Converter<String, LocalDateTime> reverseMapLocalDateTime =
                ctx -> MappingUtil.reverseMapLocalDateTime(ctx.getSource());

        return new PropertyMap<TicketDto, Ticket>() {
            @Override
            protected void configure() {
                using(reverseMapLocalDateTime).map(source.getDateTime(), destination.getDateTime());
            }
        };
    }
}
