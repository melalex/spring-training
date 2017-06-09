package ua.room414.facade.mapping;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Ticket;
import ua.room414.dto.TicketDto;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Component
public class TicketReversePropertyMap extends PropertyMap<TicketDto, Ticket> {

    @Override
    protected void configure() {
        map().setDateTime(MappingUtil.reverseMapLocalDateTime(source.getDateTime()));
    }
}
