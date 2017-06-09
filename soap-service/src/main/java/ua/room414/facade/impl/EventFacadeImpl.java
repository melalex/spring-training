package ua.room414.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.domain.entity.Event;
import ua.room414.dto.EventDto;
import ua.room414.event.EventList;
import ua.room414.facade.EventFacade;
import ua.room414.facade.converter.Converter;
import ua.room414.service.EventService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
@Facade
public class EventFacadeImpl implements EventFacade {
    private EventService eventService;
    private Converter<Event, EventDto> converter;

    @Autowired
    public EventFacadeImpl(EventService eventService, Converter<Event, EventDto> converter) {
        this.eventService = eventService;
        this.converter = converter;
    }

    @Override
    public EventDto save(final EventDto object) {
        Event event = converter.reverse(object);

        event = eventService.save(event);

        return converter.convert(event);
    }

    @Override
    public void remove(final EventDto object) {
        Event event = converter.reverse(object);
        eventService.remove(event);
    }

    @Override
    public EventDto getById(final Long id) {
        return converter.convert(eventService.getById(id));
    }

    @Override
    public EventList getAll() {
        List<Event> events = eventService.getAll();
        return mapEventList(events);
    }

    @Override
    public EventDto getByName(final String name) {
        return converter.convert(eventService.getByName(name));
    }

    private EventList mapEventList(final List<Event> events) {
        EventList eventList = new EventList();

        List<EventDto> content = events.stream()
                .map(converter::convert)
                .collect(Collectors.toList());

        eventList.getEvent().addAll(content);

        return eventList;
    }
}
