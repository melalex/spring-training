package ua.room414.facade.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Component
public class LocalDateReverseConverter extends AbstractConverter<String, LocalDate> {

    @Override
    protected LocalDate convert(String source) {
        return LocalDate.parse(source);
    }
}
