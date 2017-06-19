package ua.room414.repository;

import org.springframework.data.repository.CrudRepository;
import ua.room414.domain.User;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
}
