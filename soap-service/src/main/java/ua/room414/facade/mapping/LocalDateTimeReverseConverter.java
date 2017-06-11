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
public class LocalDateTimeReverseConverter extends ConverterConfigurerSupport<String, LocalDateTime> {

    @Override
    protected Converter<String, LocalDateTime> converter() {
        return new AbstractConverter<String, LocalDateTime>() {
            @Override
            protected LocalDateTime convert(String source) {
                return MappingUtil.reverseMapLocalDateTime(source);
            }
        };
    }
}
