package ua.room414.service.impl;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.Event;
import ua.room414.repository.EventRepository;
import ua.room414.service.EventService;

import java.util.List;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event object) {
        return eventRepository.save(object);
    }

    @Override
    public void remove(Event object) {
        eventRepository.delete(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Event getById(Long id) {
        return eventRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAll() {
        return Lists.newArrayList(eventRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Event getByName(String name) {
        return eventRepository.findEventByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Event> getForDateRange(LocalDate from, LocalDate to) {
        DateTime begin = from.toDateTimeAtStartOfDay();
        DateTime end = to.plusDays(1).toDateTimeAtStartOfDay();

        return eventRepository.findAllByAirDatesAfterAndAirDatesBefore(begin, end);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Event> getNextEvents(DateTime to) {
        return eventRepository.findAllByAirDatesAfterAndAirDatesBefore(DateTime.now(), to);
    }
}