package ua.room414.service.strategy.impl;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.stereotype.Component;
import ua.room414.domain.Event;
import ua.room414.domain.User;
import ua.room414.service.strategy.DiscountStrategy;



/**
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
@Component
public class BirthdayDiscountStrategy implements DiscountStrategy {
    private static final int DAY_INTERVAL = 5;
    private static final double DISCOUNT = 0.95;

    @Override
    public double getDiscount(User user, Event event, DateTime airDateTime, int numberOfTickets) {
        Interval interval = new Interval(airDateTime, airDateTime.plusDays(DAY_INTERVAL));

        if (interval.contains(user.getBirthday().toDateTimeAtCurrentTime())) {
            return DISCOUNT;
        }

        return 1;
    }
}
