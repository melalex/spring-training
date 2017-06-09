package ua.room414.service;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface CrudService<K, E> {
    /**
     * Saving new object to storage or updating existing one
     *
     * @param object Object to save
     * @return saved object with assigned id
     */
    E save(E object);

    /**
     * Removing object from storage
     *
     * @param object Object to remove
     */
    void remove(E object);

    /**
     * Getting object by id from storage
     *
     * @param id id of the object
     * @return Found object or <code>null</code>
     */
    E getById(K id);

    /**
     * Getting all objects from storage
     *
     * @return collection of objects
     */
    List<E> getAll();
}
