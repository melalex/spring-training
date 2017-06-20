package ua.room414.service.strategy;

import org.joda.time.DateTime;
import ua.room414.domain.Event;
import ua.room414.domain.User;

/**
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
public interface DiscountStrategy {

    double getDiscount(User user, Event event, DateTime airDateTime, int numberOfTickets);
}
