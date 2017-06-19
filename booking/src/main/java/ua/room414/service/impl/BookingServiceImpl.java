package ua.room414.service.impl;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.Event;
import ua.room414.domain.Ticket;
import ua.room414.domain.User;
import ua.room414.repository.TicketRepository;
import ua.room414.service.BookingService;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private TicketRepository ticketRepository;

    @Autowired
    public BookingServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {
        return 0;
    }

    @Override
    public void bookTickets(Set<Ticket> tickets) {
        ticketRepository.save(tickets);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return Sets.newHashSet(ticketRepository.findAllByEventAndDateTime(event, dateTime));
    }
}
