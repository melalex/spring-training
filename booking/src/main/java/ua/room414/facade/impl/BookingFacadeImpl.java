package ua.room414.facade.impl;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotations.Facade;
import ua.room414.domain.Event;
import ua.room414.domain.Ticket;
import ua.room414.domain.User;
import ua.room414.facade.BookingFacade;
import ua.room414.facade.dto.EventDto;
import ua.room414.facade.dto.TicketDto;
import ua.room414.facade.dto.TicketList;
import ua.room414.facade.dto.UserDto;
import ua.room414.service.BookingService;

import java.lang.reflect.Type;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
@Facade
public class BookingFacadeImpl implements BookingFacade {
    private BookingService bookingService;
    private ModelMapper modelMapper;

    @Autowired
    public BookingFacadeImpl(BookingService bookingService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }

    @Override
    public double getTicketsPrice(final EventDto event, final DateTime dateTime, final UserDto user, final Set<Integer> seats) {
        final User userEntity = modelMapper.map(user, User.class);
        final Event eventEntity = modelMapper.map(event, Event.class);

        return bookingService.getTicketsPrice(eventEntity, dateTime, userEntity, seats);
    }

    @Override
    public void bookTickets(final Set<TicketDto> tickets) {
        bookingService.bookTickets(mapTickets(tickets));
    }

    @Override
    public TicketList getPurchasedTicketsForEvent(final EventDto event, final DateTime dateTime) {
        final Event eventEntity = modelMapper.map(event, Event.class);
        final Set<Ticket> tickets = bookingService.getPurchasedTicketsForEvent(eventEntity, dateTime);

        return mapTicketList(tickets);
    }

    private Set<Ticket> mapTickets(final Set<TicketDto> source) {
        final Type listType = new TypeToken<Set<Ticket>>() {}.getType();

        return modelMapper.map(source, listType);
    }

    private TicketList mapTicketList(final Iterable<Ticket> source) {
        final Type listType = new TypeToken<Iterable<TicketDto>>() {}.getType();
        final Iterable<TicketDto> destination = modelMapper.map(source, listType);

        return TicketList.of(destination);
    }
}
