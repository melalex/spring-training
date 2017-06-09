package ua.room414.service;

import ua.room414.domain.entity.Auditorium;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface AuditoriumService {
    /**
     * Getting all auditoriums from the system
     *
     * @return set of all auditoriums
     */
    Set<Auditorium> getAll();

    /**
     * Finding auditorium by name
     *
     * @param name Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    Auditorium getByName(String name);
}
