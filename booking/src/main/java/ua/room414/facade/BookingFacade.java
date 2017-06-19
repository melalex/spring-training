package ua.room414.facade;

import ua.room414.facade.dto.EventDto;
import ua.room414.facade.dto.TicketDto;
import ua.room414.facade.dto.UserDto;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
public interface BookingFacade {
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
    double getTicketsPrice(EventDto event, LocalDateTime dateTime, UserDto user, Set<Long> seats);

    /**
     * Books tickets in internal system. If user is not
     * <code>null</code> in a ticket then booked tickets are saved with it
     *
     * @param tickets Set of tickets
     */
    void bookTickets(Set<TicketDto> tickets);

    /**
     * Getting all purchased tickets for event on specific air date and time
     *
     * @param event    Event to get tickets for
     * @param dateTime Date and time of airing of event
     * @return set of all purchased tickets
     */
    Set<TicketDto> getPurchasedTicketsForEvent(EventDto event, LocalDateTime dateTime);

}
