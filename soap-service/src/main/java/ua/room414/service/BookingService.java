package ua.room414.service;

import ua.room414.domain.entity.Event;
import ua.room414.domain.entity.Ticket;
import ua.room414.domain.entity.User;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface BookingService {
    /**
     * Getting price when buying all supplied seats for particular event
     *
     * @param event    Event to get base ticket price, vip seats and other
     *                 information
     * @param dateTime Date and time of event air
     * @param user     User that buys ticket could be needed to calculate discount.
     *                 Can be <code>null</code>
     * @param seats    Set of seat numbers that user wants to buy
     * @return total price
     */
    double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats);

    /**
     * Books tickets in internal system. If user is not
     * <code>null</code> in a ticket then booked tickets are saved with it
     *
     * @param tickets Set of tickets
     */
    void bookTickets(Set<Ticket> tickets);

    /**
     * Getting all purchased tickets for event on specific air date and time
     *
     * @param event    Event to get tickets for
     * @param dateTime Date and time of airing of event
     * @return set of all purchased tickets
     */
    Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);
}
