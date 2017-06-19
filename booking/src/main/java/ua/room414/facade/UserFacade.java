package ua.room414.facade;

import ua.room414.facade.dto.UserDto;
import ua.room414.facade.dto.UserList;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
public interface UserFacade extends CrudFacade<Long, UserDto> {
    /**
     * Finding user by email
     *
     * @param email Email of the user
     * @return found user or <code>null</code>
     */
    UserDto getUserByEmail(String email);

    /**
     * Getting all objects from storage
     *
     * @return collection of objects
     */
    UserList getAll();
}
