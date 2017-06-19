package ua.room414.facade.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Component
public class LocalDateTimeReverseConverter extends AbstractConverter<String, LocalDateTime> {

    @Override
    protected LocalDateTime convert(String source) {
        return null;
    }
}
