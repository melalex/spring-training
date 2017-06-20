package ua.room414.facade.mapping;

import org.joda.time.DateTime;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Component
public class LocalDateTimeReverseConverter extends AbstractConverter<String, DateTime> {

    @Override
    protected DateTime convert(String source) {
        return DateTime.parse(source);
    }
}
