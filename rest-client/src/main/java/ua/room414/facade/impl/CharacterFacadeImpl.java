package ua.room414.facade.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import ua.room414.anotation.Facade;
import ua.room414.domain.Character;
import ua.room414.domain.FilterCharacterRequest;
import ua.room414.facade.CharacterFacade;
import ua.room414.facade.dto.CharacterDetailsDto;
import ua.room414.facade.dto.CharacterDto;
import ua.room414.facade.dto.FilterCharacterRequestDto;
import ua.room414.service.CharacterService;

import java.lang.reflect.Type;
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
    public List<CharacterDto> filter(final FilterCharacterRequestDto request) {
        final FilterCharacterRequest filterCharacterRequest = modelMapper.map(request, FilterCharacterRequest.class);
        final Type charactersListType = new TypeToken<List<CharacterDto>>() {}.getType();
        final List<Character> characters = characterService.filter(filterCharacterRequest);

        return modelMapper.map(characters, charactersListType);
    }

    @Override
    public CharacterDetailsDto find(long id) {
        final Character character = characterService.find(id);

        return modelMapper.map(character, CharacterDetailsDto.class);
    }
}
