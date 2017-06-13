package ua.room414.service;

import ua.room414.domain.Character;
import ua.room414.domain.FilterCharacterRequest;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
public interface CharacterService {

    List<Character> filter(FilterCharacterRequest request);

    Character find(long id);

    Character find(String url);
}
