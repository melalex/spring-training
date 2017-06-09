package ua.room414.facade.mapping;

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
public class EventPropertyMap extends PropertyMap<Event, EventDto> {

    @Override
    protected void configure() {
        map().setAirDates(mapAirDates(source.getAirDates()));
        map().setRating(mapRating(source.getRating()));
    }

    private XmlSetWrapper mapAirDates(Set<LocalDateTime> airDates) {
        XmlSetWrapper result = new XmlSetWrapper();

        result.getContent().addAll(airDates.stream().map(MappingUtil::mapLocalDateTime).collect(Collectors.toSet()));

        return result;
    }

    private EventDtoRating mapRating(EventRating eventRating) {
        return EventDtoRating.fromValue(eventRating.name());
    }

}
