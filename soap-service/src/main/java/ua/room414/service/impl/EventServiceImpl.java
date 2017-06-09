package ua.room414.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.entity.Event;
import ua.room414.repository.EventRepository;
import ua.room414.service.EventService;

import java.util.List;

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
}
