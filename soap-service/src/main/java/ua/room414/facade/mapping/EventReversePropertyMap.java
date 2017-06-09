package ua.room414.facade.mapping;

import com.google.common.collect.Sets;
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
public class EventReversePropertyMap extends PropertyMap<EventDto, Event> {

    @Override
    protected void configure() {
        map().setAirDates(mapAirDates(source.getAirDates()));
        map().setRating(mapRating(source.getRating()));
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
