package ua.room414.service;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import ua.room414.domain.Event;

import java.util.Set;

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

    /**
     * Finding all events that air on specified date range
     *
     * @param from Start date
     *
     * @param to End date inclusive
     *
     * @return Set of events
     */
    Set<Event> getForDateRange(LocalDate from, LocalDate to);

    /**
     * Return events from 'now' till the the specified date time
     *
     * @param to End date time inclusive
     * s
     * @return Set of events
     */
    Set<Event> getNextEvents(DateTime to);
}
