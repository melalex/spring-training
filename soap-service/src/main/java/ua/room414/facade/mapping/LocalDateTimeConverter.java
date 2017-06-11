package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 11 Jun 2017
 */
@Component
public class LocalDateTimeConverter extends ConverterConfigurerSupport<LocalDateTime, String> {

    @Override
    protected Converter<LocalDateTime, String> converter() {
        return new AbstractConverter<LocalDateTime, String>() {
            @Override
            protected String convert(LocalDateTime source) {
                return MappingUtil.mapLocalDateTime(source);
            }
        };
    }
}
