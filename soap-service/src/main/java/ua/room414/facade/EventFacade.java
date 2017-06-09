package ua.room414.facade;

import ua.room414.dto.EventDto;
import ua.room414.event.EventList;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
public interface EventFacade extends CrudFacade<Long, EventDto> {
    /**
     * Finding event by name
     *
     * @param name Name of the event
     * @return found event or <code>null</code>
     */
    EventDto getByName(String name);

    /**
     * Getting all objects from storage
     *
     * @return collection of objects
     */
    EventList getAll();
}
