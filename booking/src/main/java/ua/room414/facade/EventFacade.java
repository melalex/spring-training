package ua.room414.facade;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import ua.room414.facade.dto.EventDto;
import ua.room414.facade.dto.EventList;

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

    /**
     * Finding all events that air on specified date range
     *
     * @param from Start date
     *
     * @param to End date inclusive
     *
     * @return Set of events
     */
    EventList getForDateRange(LocalDate from, LocalDate to);

    /**
     * Return events from 'now' till the the specified date time
     *
     * @param to End date time inclusive
     * s
     * @return Set of events
     */
    EventList getNextEvents(DateTime to);
}
