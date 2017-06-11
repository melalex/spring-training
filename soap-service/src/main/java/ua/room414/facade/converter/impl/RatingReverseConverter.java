package ua.room414.facade.converter.impl;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.EventRating;
import ua.room414.dto.EventDtoRating;

/**
 * @author Alexander Melashchenko
 * @version 1.0 11 Jun 2017
 */
@Component
public class RatingReverseConverter extends ConverterConfigurerSupport<EventDtoRating, EventRating> {

    @Override
    protected Converter<EventDtoRating, EventRating> converter() {
        return new AbstractConverter<EventDtoRating, EventRating>() {

            @Override
            protected EventRating convert(EventDtoRating source) {
                return EventRating.valueOf(source.name());
            }
        };
    }
}
