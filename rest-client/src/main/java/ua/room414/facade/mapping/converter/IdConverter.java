package ua.room414.facade.mapping.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Component
public class IdConverter extends AbstractConverter<String, Long> {

    @Override
    protected Long convert(String source) {
        return Long.parseLong(source.substring(source.lastIndexOf('/') + 1));
    }
}
