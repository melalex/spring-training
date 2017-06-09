package ua.room414.service;

import ua.room414.domain.entity.Event;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface EventService extends CrudService<Long, Event> {

    /**
     * Finding event by name
     *
     * @param name Name of the event
     * @return found event or <code>null</code>
     */
    Event getByName(String name);
}
