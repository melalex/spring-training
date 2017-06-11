package ua.room414.facade.mapping;

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
public class RatingConverter extends ConverterConfigurerSupport<EventRating, EventDtoRating> {

    @Override
    protected Converter<EventRating, EventDtoRating> converter() {
        return new AbstractConverter<EventRating, EventDtoRating>() {
            @Override
            protected EventDtoRating convert(EventRating source) {
                return EventDtoRating.fromValue(source.name());
            }
        };
    }
}
