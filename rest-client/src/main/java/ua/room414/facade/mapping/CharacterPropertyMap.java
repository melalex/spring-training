package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.room414.domain.Character;
import ua.room414.facade.dto.CharacterDto;
import ua.room414.facade.mapping.converter.IdConverter;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Component
public class CharacterPropertyMap extends PropertyMapConfigurerSupport<Character, CharacterDto> {
    private IdConverter idConverter;

    @Autowired
    public void setIdConverter(IdConverter idConverter) {
        this.idConverter = idConverter;
    }

    @Override
    public PropertyMap<Character, CharacterDto> mapping() {
        return new PropertyMap<Character, CharacterDto>() {
            @Override
            protected void configure() {
                using(idConverter).map(source.getUrl(), destination.getId());
            }
        };
    }
}
