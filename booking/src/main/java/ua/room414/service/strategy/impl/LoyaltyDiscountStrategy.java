package ua.room414.service.strategy.impl;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import ua.room414.domain.Event;
import ua.room414.domain.User;
import ua.room414.service.strategy.DiscountStrategy;

/**
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
@Component
public class LoyaltyDiscountStrategy implements DiscountStrategy {
    private static final int DISCOUNT_TICKETS_COUNT = 10;
    private static final double DISCOUNT_PER_TICKET = 0.5;

    @Override
    public double getDiscount(User user, Event event, DateTime airDateTime, int numberOfTickets) {
        int discountedTicketsCount = numberOfTickets / DISCOUNT_TICKETS_COUNT;
        double discountedTicketsPart = discountedTicketsCount / numberOfTickets;

        return 1 - discountedTicketsPart * DISCOUNT_PER_TICKET;
    }
}
