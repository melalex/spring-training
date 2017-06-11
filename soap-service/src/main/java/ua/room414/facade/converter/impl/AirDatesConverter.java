package ua.room414.facade.converter.impl;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;
import ua.room414.dto.XmlSetWrapper;
import ua.room414.facade.mapping.MappingUtil;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 11 Jun 2017
 */
@Component
public class AirDatesConverter extends ConverterConfigurerSupport<Set<LocalDateTime>, XmlSetWrapper> {

    @Override
    protected Converter<Set<LocalDateTime>, XmlSetWrapper> converter() {
        return new AbstractConverter<Set<LocalDateTime>, XmlSetWrapper>() {

            @Override
            protected XmlSetWrapper convert(Set<LocalDateTime> source) {
                XmlSetWrapper result = new XmlSetWrapper();

                result.getContent().addAll(
                        source.stream()
                                .map(MappingUtil::mapLocalDateTime)
                                .collect(Collectors.toSet())
                );

                return result;
            }
        };
    }
}
