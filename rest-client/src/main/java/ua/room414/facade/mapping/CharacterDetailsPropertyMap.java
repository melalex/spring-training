package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.room414.domain.Character;
import ua.room414.facade.dto.CharacterDetailsDto;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Component
public class CharacterDetailsPropertyMap extends PropertyMapConfigurerSupport<Character, CharacterDetailsDto> {
    private Converter<String, Long> idConverter;
    private Converter<String, CharacterDetailsDto.FamilyMember> familyMemberConverter;

    @Autowired
    public void setIdConverter(Converter<String, Long> idConverter) {
        this.idConverter = idConverter;
    }

    @Autowired
    public void setFamilyMemberConverter(Converter<String, CharacterDetailsDto.FamilyMember> familyMemberConverter) {
        this.familyMemberConverter = familyMemberConverter;
    }

    @Override
    public PropertyMap<Character, CharacterDetailsDto> mapping() {
        return new PropertyMap<Character, CharacterDetailsDto>() {
            @Override
            protected void configure() {
                using(idConverter).map(source.getUrl(), destination.getId());

                using(familyMemberConverter).map(source.getFather(), destination.getFather());
                using(familyMemberConverter).map(source.getMather(), destination.getMather());
                using(familyMemberConverter).map(source.getSpouse(), destination.getSpouse());
            }
        };
    }
}
