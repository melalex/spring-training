package ua.room414.facade.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Component
public class LocalDateTimeConverter extends AbstractConverter<LocalDateTime, String> {

    @Override
    protected String convert(LocalDateTime source) {
        return null;
    }
}
