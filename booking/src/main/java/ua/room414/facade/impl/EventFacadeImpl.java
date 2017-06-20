package ua.room414.facade.impl;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.domain.Event;
import ua.room414.facade.EventFacade;
import ua.room414.facade.dto.EventDto;
import ua.room414.facade.dto.EventList;
import ua.room414.service.EventService;

import java.lang.reflect.Type;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
@Facade
public class EventFacadeImpl implements EventFacade {
    private EventService eventService;
    private ModelMapper modelMapper;

    @Autowired
    public EventFacadeImpl(EventService eventService, ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    @Override
    public EventDto save(final EventDto object) {
        Event event = modelMapper.map(object, Event.class);

        event = eventService.save(event);

        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public void remove(final EventDto object) {
        final Event event = modelMapper.map(object, Event.class);
        eventService.remove(event);
    }

    @Override
    public EventDto getById(final Long id) {
        return modelMapper.map(eventService.getById(id), EventDto.class);
    }

    @Override
    public EventList getAll() {
        return mapEventList(eventService.getAll());
    }

    @Override
    public EventList getForDateRange(LocalDate from, LocalDate to) {
        return mapEventList(eventService.getForDateRange(from, to));
    }

    @Override
    public EventList getNextEvents(DateTime to) {
        return mapEventList(eventService.getNextEvents(to));
    }

    @Override
    public EventDto getByName(final String name) {
        return modelMapper.map(eventService.getByName(name), EventDto.class);
    }

    private EventList mapEventList(final Iterable<Event> events) {
        final Type listType = new TypeToken<Iterable<EventDto>>() {}.getType();
        final Iterable<EventDto> eventDtos = modelMapper.map(events, listType);

        return EventList.of(eventDtos);
    }
}
