package ua.room414.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.Event;
import ua.room414.domain.User;
import ua.room414.service.DiscountService;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {
    @Override
    public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
        return 0;
    }
}
