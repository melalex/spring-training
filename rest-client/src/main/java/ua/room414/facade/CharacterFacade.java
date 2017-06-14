package ua.room414.facade;

import ua.room414.facade.dto.CharacterDto;
import ua.room414.facade.dto.FilterCharacterRequestDto;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
public interface CharacterFacade {

    List<CharacterDto> filter(FilterCharacterRequestDto request);

    CharacterDto find(long id);
}
