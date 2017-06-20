package ua.room414.facade.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Component
public class LocalDateConverter extends AbstractConverter<LocalDate, String> {

    @Override
    protected String convert(LocalDate source) {
        return source.toString();
    }
}
