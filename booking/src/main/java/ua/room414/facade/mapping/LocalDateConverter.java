package ua.room414.facade.mapping;

import org.joda.time.LocalDate;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;


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
