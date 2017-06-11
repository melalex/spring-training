package ua.room414.facade.converter.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Ticket;
import ua.room414.domain.entity.User;
import ua.room414.dto.TicketDto;
import ua.room414.dto.UserDto;
import ua.room414.facade.converter.Converter;

import java.lang.reflect.Type;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Component
public class UserConverter implements Converter<User, UserDto> {
    private ModelMapper modelMapper;

    @Autowired
    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto convert(User object) {
        UserDto userDto = modelMapper.map(object, UserDto.class);

        userDto.setTickets(mapTickets(object.getTickets()));

        return userDto;
    }

    @Override
    public User reverse(UserDto object) {
        User user = modelMapper.map(object, User.class);

        user.setTickets(reverseMapTickets(object.getTickets()));

        return user;
    }

    private UserDto.Tickets mapTickets(Set<Ticket> tickets) {
        UserDto.Tickets result = new UserDto.Tickets();

        Type targetSetType = new TypeToken<Set<TicketDto>>() {}.getType();
        Set<TicketDto> ticketDtos = modelMapper.map(tickets, targetSetType);

        result.getTicketDto().addAll(ticketDtos);

        return result;
    }

    private Set<Ticket> reverseMapTickets(UserDto.Tickets ticketDtos) {
        Type targetSetType = new TypeToken<Set<Ticket>>() {}.getType();
        return modelMapper.map(ticketDtos.getTicketDto(), targetSetType);
    }
}
