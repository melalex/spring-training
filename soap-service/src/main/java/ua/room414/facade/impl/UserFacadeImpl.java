package ua.room414.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.domain.entity.User;
import ua.room414.dto.UserDto;
import ua.room414.facade.UserFacade;
import ua.room414.facade.converter.Converter;
import ua.room414.service.UserService;
import ua.room414.user.UserList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
@Facade
public class UserFacadeImpl implements UserFacade {
    private UserService userService;
    private Converter<User, UserDto> converter;

    @Autowired
    public UserFacadeImpl(UserService userService, Converter<User, UserDto> converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @Override
    public UserDto save(final UserDto object) {
        User user = converter.reverse(object);

        user = userService.save(user);

        return converter.convert(user);
    }

    @Override
    public void remove(final UserDto object) {
        User user = converter.reverse(object);
        userService.remove(user);
    }

    @Override
    public UserDto getById(final Long id) {
        return converter.convert(userService.getById(id));
    }

    @Override
    public UserList getAll() {
        List<User> users = userService.getAll();
        return mapUserList(users);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return converter.convert(userService.getUserByEmail(email));
    }

    private UserList mapUserList(final List<User> users) {
        UserList userList = new UserList();

        List<UserDto> content = users.stream()
                .map(converter::convert)
                .collect(Collectors.toList());

        userList.getUser().addAll(content);

        return userList;
    }
}
