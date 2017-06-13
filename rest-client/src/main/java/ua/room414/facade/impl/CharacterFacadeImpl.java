package ua.room414.facade.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.facade.CharacterFacade;
import ua.room414.domain.Character;
import ua.room414.domain.FilterCharacterRequest;
import ua.room414.facade.dto.CharacterDto;
import ua.room414.service.CharacterService;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
@Facade
public class CharacterFacadeImpl implements CharacterFacade {
    private CharacterService characterService;
    private ModelMapper modelMapper;

    @Autowired
    public CharacterFacadeImpl(CharacterService characterService, ModelMapper modelMapper) {
        this.characterService = characterService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CharacterDto> filter(FilterCharacterRequest request) {
        return null;
    }

    @Override
    public CharacterDto find(long id) {
        return null;
    }
}
