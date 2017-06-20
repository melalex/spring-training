package ua.room414.facade.mapping;

import org.joda.time.LocalDate;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;


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
