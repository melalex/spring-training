package ua.room414.util;

import org.aspectj.lang.annotation.*;
import org.joda.time.DateTime;
import ua.room414.domain.Event;
import ua.room414.domain.Ticket;
import ua.room414.domain.User;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Count how many times each event was accessed by name,
 * how many times its prices were queried, how many times its tickets were booked.
 * Store counters in map for now (later could be replaced by DB dao)
 *
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 *
 * @see ua.room414.service.EventService#getByName(String)
 * @see ua.room414.service.BookingService#getTicketsPrice(Event, DateTime, User, Set)
 * @see ua.room414.service.BookingService#bookTickets(Set)
 */
@Aspect
public class CounterAspect {
    private ConcurrentMap<Long, Long> getByNameCounter = new ConcurrentHashMap<>();
    private ConcurrentMap<Long, Long> getTicketsPriceCounter = new ConcurrentHashMap<>();
    private ConcurrentMap<Long, Long> bookTicketsCounter = new ConcurrentHashMap<>();

    @Pointcut("execution(* ua.room414.service.EventService.getByName(..))")
    public void getEventByName() {

    }

    @Pointcut("execution(* ua.room414.service.BookingService.getTicketsPrice(..)) && args(event)")
    public void getTicketsPrice(Event event) {

    }

    @Pointcut("execution(* ua.room414.service.BookingService.bookTickets(..)) && args(tickets)")
    public void bookTickets(Set<Ticket> tickets) {

    }

    @AfterReturning(value = "getEventByName()", returning = "event")
    public void doCountGetEventByName(Event event) {
        getByNameCounter.compute(event.getId(), this::counter);
    }

    @Before(value = "getTicketsPrice(event)", argNames = "event")
    public void doCountGetTicketsPrice(Event event) {
        getTicketsPriceCounter.compute(event.getId(), this::counter);
    }

    @Before(value = "bookTickets(tickets)", argNames = "tickets")
    public void doCountBookTickets(Set<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            bookTicketsCounter.compute(ticket.getEvent().getId(), this::counter);
        }
    }

    private Long counter(Long key, Long oldValue) {
        long value = Objects.nonNull(oldValue) ? oldValue : 0;
        return value + 1;
    }
}
