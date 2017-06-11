package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import com.google.common.collect.Sets;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Event;
import ua.room414.domain.entity.EventRating;
import ua.room414.dto.EventDto;
import ua.room414.dto.EventDtoRating;
import ua.room414.dto.XmlSetWrapper;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Component
public class EventReversePropertyMap extends PropertyMapConfigurerSupport<EventDto, Event> {

    @Override
    public PropertyMap<EventDto, Event> mapping() {
        final Converter<XmlSetWrapper, Set<LocalDateTime>> mapAirDates =
                ctx -> mapAirDates(ctx.getSource());

        final Converter<EventDtoRating, EventRating> mapRating =
                ctx -> mapRating(ctx.getSource());

        return new PropertyMap<EventDto, Event>() {
            @Override
            protected void configure() {
                using(mapAirDates).map(source.getAirDates(), destination.getAirDates());
                using(mapRating).map(source.getRating(), destination.getRating());
            }
        };
    }

    private EventRating mapRating(EventDtoRating rating) {
        return EventRating.valueOf(rating.name());
    }

    private Set<LocalDateTime> mapAirDates(XmlSetWrapper airDates) {
        return Sets.newHashSet(
                airDates.getContent()
                        .stream()
                        .map(MappingUtil::reverseMapLocalDateTime)
                        .collect(Collectors.toSet())
        );
    }
}
