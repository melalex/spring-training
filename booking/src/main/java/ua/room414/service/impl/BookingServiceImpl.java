package ua.room414.service.impl;

import com.google.common.collect.Sets;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.*;
import ua.room414.repository.TicketRepository;
import ua.room414.service.BookingService;
import ua.room414.service.DiscountService;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private static final double VIP_SEAT_TAX = 2;
    private static final double HIGH_RATED_TAX = 1.2;

    private TicketRepository ticketRepository;
    private DiscountService discountService;

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Autowired
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public double getTicketsPrice(final Event event, final DateTime dateTime, final User user, final Set<Integer> seats) {
        final Auditorium auditorium = event.getAuditoriums().get(dateTime);

        final double discount = discountService.getDiscount(user, event, dateTime, seats.size());
        final double basePrice = event.getBasePrice();

        double result = 0;

        for (Integer seat : seats) {
            if (auditorium.getVipSeats().contains(seat)) {
                result += basePrice * VIP_SEAT_TAX;
            } else {
                result += basePrice;
            }
        }

        if (event.getRating() == EventRating.HIGH) {
            result *= HIGH_RATED_TAX;
        }

        return result * discount;
    }

    @Override
    public void bookTickets(Set<Ticket> tickets) {
        ticketRepository.save(tickets);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Ticket> getPurchasedTicketsForEvent(final Event event, final DateTime dateTime) {
        return Sets.newHashSet(ticketRepository.findAllByEventAndDateTime(event, dateTime));
    }
}
