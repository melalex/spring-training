package ua.room414.facade;

import ua.room414.domain.Character;
import ua.room414.domain.FilterCharacterRequest;
import ua.room414.facade.dto.CharacterDto;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
public interface CharacterFacade {

    List<CharacterDto> filter(FilterCharacterRequest request);

    CharacterDto find(long id);
}
