package ua.room414.facade;

import ua.room414.dto.AuditoriumDto;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
public interface AuditoriumFacade {
    /**
     * Getting all auditoriums from the system
     *
     * @return set of all auditoriums
     */
    Set<AuditoriumDto> getAll();

    /**
     * Finding auditorium by name
     *
     * @param name Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    AuditoriumDto getByName(String name);

}
