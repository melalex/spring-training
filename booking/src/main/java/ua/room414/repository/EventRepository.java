package ua.room414.repository;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.repository.CrudRepository;
import ua.room414.domain.Event;

import java.util.List;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface EventRepository extends CrudRepository<Event, Long> {

    Event findEventByName(String name);

    Set<Event> findAllByAirDatesAfterAndAirDatesBefore(DateTime from, DateTime to);
}
