package ua.room414.service;

import ua.room414.domain.User;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface UserService extends CrudService<Long, User> {

    /**
     * Finding user by email
     *
     * @param email Email of the user
     * @return found user or <code>null</code>
     */
    User getUserByEmail(String email);
}
