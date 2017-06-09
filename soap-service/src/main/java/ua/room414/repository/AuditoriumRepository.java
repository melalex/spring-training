package ua.room414.repository;

import org.springframework.data.repository.CrudRepository;
import ua.room414.domain.entity.Auditorium;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {
    Auditorium findAuditoriumByName(String name);
}
