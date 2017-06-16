package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import org.modelmapper.Converter;
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
    private Converter<String, Long> idConverter;
    private Converter<String, String> emptyStringConverter;

    @Autowired
    public CharacterPropertyMap(Converter<String, Long> idConverter, Converter<String, String> emptyStringConverter) {
        this.idConverter = idConverter;
        this.emptyStringConverter = emptyStringConverter;
    }

    @Override
    public PropertyMap<Character, CharacterDto> mapping() {
        return new PropertyMap<Character, CharacterDto>() {
            @Override
            protected void configure() {
                using(idConverter).map(source.getUrl(), destination.getId());

                using(emptyStringConverter).map(source.getName(), destination.getName());
                using(emptyStringConverter).map(source.getCulture(), destination.getCulture());
                using(emptyStringConverter).map(source.getBorn(), destination.getBorn());
                using(emptyStringConverter).map(source.getDied(), destination.getDied());
            }
        };
    }
}
