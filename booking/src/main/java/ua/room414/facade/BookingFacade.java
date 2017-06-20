package ua.room414.facade;

import org.joda.time.DateTime;
import ua.room414.facade.dto.EventDto;
import ua.room414.facade.dto.TicketDto;
import ua.room414.facade.dto.TicketList;
import ua.room414.facade.dto.UserDto;

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
    double getTicketsPrice(EventDto event, DateTime dateTime, UserDto user, Set<Integer> seats);

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
    TicketList getPurchasedTicketsForEvent(EventDto event, DateTime dateTime);
}
