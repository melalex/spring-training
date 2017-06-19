package ua.room414.facade.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.domain.User;
import ua.room414.facade.UserFacade;
import ua.room414.facade.dto.UserDto;
import ua.room414.facade.dto.UserList;
import ua.room414.service.UserService;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
@Facade
public class UserFacadeImpl implements UserFacade {
    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserFacadeImpl(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(final UserDto object) {
        User user = modelMapper.map(object, User.class);

        user = userService.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void remove(final UserDto object) {
        User user = modelMapper.map(object, User.class);
        userService.remove(user);
    }

    @Override
    public UserDto getById(final Long id) {
        return modelMapper.map(userService.getById(id), UserDto.class);
    }

    @Override
    public UserList getAll() {
        List<User> users = userService.getAll();
        return mapUserList(users);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return modelMapper.map(userService.getUserByEmail(email), UserDto.class);
    }

    private UserList mapUserList(final Iterable<User> users) {
        Type listType = new TypeToken<Iterable<UserDto>>() {}.getType();
        Iterable<UserDto> userDtos = modelMapper.map(users, listType);

        return UserList.of(userDtos);
    }
}
