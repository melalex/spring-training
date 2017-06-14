package ua.room414.facade.mapping.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.room414.domain.Character;
import ua.room414.facade.dto.CharacterDetailsDto;
import ua.room414.service.CharacterService;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Component
public class FamilyMemberConverter extends AbstractConverter<String, CharacterDetailsDto.FamilyMember> {
    private IdConverter idConverter;
    private CharacterService characterService;

    @Autowired
    public FamilyMemberConverter(IdConverter idConverter, CharacterService characterService) {
        this.idConverter = idConverter;
        this.characterService = characterService;
    }

    @Override
    protected CharacterDetailsDto.FamilyMember convert(final String source) {
        final Character character = characterService.find(source);
        final CharacterDetailsDto.FamilyMember familyMember = new CharacterDetailsDto.FamilyMember();

        familyMember.setId(idConverter.convert(character.getUrl()));
        familyMember.setName(character.getName());

        return familyMember;
    }
}
