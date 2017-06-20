package ua.room414.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.Event;
import ua.room414.domain.User;
import ua.room414.service.DiscountService;
import ua.room414.service.strategy.DiscountStrategy;

import java.util.Comparator;
import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {
    private List<DiscountStrategy> discountStrategies;

    @Autowired
    public DiscountServiceImpl(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    @Override
    public double getDiscount(final User user, final Event event, final DateTime airDateTime, final int numberOfTickets) {
        return discountStrategies
                .stream()
                .map(s -> s.getDiscount(user, event, airDateTime, numberOfTickets))
                .min(Comparator.comparingDouble(a -> a))
                .orElse(1d);
    }
}
