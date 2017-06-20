package ua.room414.facade.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.domain.Auditorium;
import ua.room414.domain.User;
import ua.room414.facade.AuditoriumFacade;
import ua.room414.facade.dto.AuditoriumDto;
import ua.room414.facade.dto.AuditoriumList;
import ua.room414.facade.dto.UserDto;
import ua.room414.facade.dto.UserList;
import ua.room414.service.AuditoriumService;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
@Facade
public class AuditoriumFacadeImpl implements AuditoriumFacade {
    private AuditoriumService auditoriumService;
    private ModelMapper modelMapper;

    @Autowired
    public AuditoriumFacadeImpl(AuditoriumService auditoriumService, ModelMapper modelMapper) {
        this.auditoriumService = auditoriumService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuditoriumList getAll() {
        final Set<Auditorium> auditoriums = auditoriumService.getAll();

        return mapAuditoriumList(auditoriums);
    }

    @Override
    public AuditoriumDto getByName(final String name) {
        final Auditorium auditorium = auditoriumService.getByName(name);

        return modelMapper.map(auditorium, AuditoriumDto.class);
    }

    private AuditoriumList mapAuditoriumList(final Iterable<Auditorium> source) {
        final Type listType = new TypeToken<Iterable<AuditoriumDto>>() {}.getType();
        final Iterable<AuditoriumDto> destination = modelMapper.map(source, listType);

        return AuditoriumList.of(destination);
    }
}
