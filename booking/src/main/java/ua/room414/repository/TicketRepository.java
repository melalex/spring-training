package ua.room414.repository;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;
import ua.room414.domain.Event;
import ua.room414.domain.Ticket;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findAllByEventAndDateTime(Event event, DateTime dateTime);
}
