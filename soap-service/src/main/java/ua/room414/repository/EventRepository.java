package ua.room414.repository;

import org.springframework.data.repository.CrudRepository;
import ua.room414.domain.entity.Event;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface EventRepository extends CrudRepository<Event, Long> {
    Event findEventByName(String name);
}
