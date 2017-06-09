package ua.room414.facade.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.room414.domain.entity.Auditorium;
import ua.room414.domain.entity.Event;
import ua.room414.domain.entity.Ticket;
import ua.room414.dto.AuditoriumDto;
import ua.room414.dto.EventDto;
import ua.room414.dto.TicketDto;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Configuration
public class MappingConfiguration {
    private PropertyMap<Auditorium, AuditoriumDto> auditoriumPropertyMap;
    private PropertyMap<AuditoriumDto, Auditorium> auditoriumReversePropertyMap;
    private PropertyMap<EventDto, Event> eventPropertyMap;
    private PropertyMap<Event, EventDto> eventReversePropertyMap;
    private PropertyMap<Ticket, TicketDto> ticketPropertyMap;
    private PropertyMap<TicketDto, Ticket> ticketReversePropertyMap;

    @Autowired
    public void setAuditoriumPropertyMap(PropertyMap<Auditorium, AuditoriumDto> auditoriumPropertyMap) {
        this.auditoriumPropertyMap = auditoriumPropertyMap;
    }

    @Autowired
    public void setAuditoriumReversePropertyMap(PropertyMap<AuditoriumDto, Auditorium> auditoriumReversePropertyMap) {
        this.auditoriumReversePropertyMap = auditoriumReversePropertyMap;
    }

    @Autowired
    public void setEventPropertyMap(PropertyMap<EventDto, Event> eventPropertyMap) {
        this.eventPropertyMap = eventPropertyMap;
    }

    @Autowired
    public void setEventReversePropertyMap(PropertyMap<Event, EventDto> eventReversePropertyMap) {
        this.eventReversePropertyMap = eventReversePropertyMap;
    }

    @Autowired
    public void setTicketPropertyMap(PropertyMap<Ticket, TicketDto> ticketPropertyMap) {
        this.ticketPropertyMap = ticketPropertyMap;
    }

    @Autowired
    public void setTicketReversePropertyMap(PropertyMap<TicketDto, Ticket> ticketReversePropertyMap) {
        this.ticketReversePropertyMap = ticketReversePropertyMap;
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(auditoriumPropertyMap);
        modelMapper.addMappings(auditoriumReversePropertyMap);
        modelMapper.addMappings(eventPropertyMap);
        modelMapper.addMappings(eventReversePropertyMap);
        modelMapper.addMappings(ticketPropertyMap);
        modelMapper.addMappings(ticketReversePropertyMap);

        return modelMapper;
    }
}
