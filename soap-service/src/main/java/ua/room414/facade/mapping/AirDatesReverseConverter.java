package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import com.google.common.collect.Sets;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;
import ua.room414.dto.XmlSetWrapper;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 11 Jun 2017
 */
@Component
public class AirDatesReverseConverter extends ConverterConfigurerSupport<XmlSetWrapper, Set<LocalDateTime>> {

    @Override
    protected Converter<XmlSetWrapper, Set<LocalDateTime>> converter() {
        return new AbstractConverter<XmlSetWrapper, Set<LocalDateTime>>() {
            @Override
            protected Set<LocalDateTime> convert(XmlSetWrapper source) {
                return Sets.newHashSet(
                        source.getContent()
                                .stream()
                                .map(MappingUtil::reverseMapLocalDateTime)
                                .collect(Collectors.toSet())
                );
            }
        };
    }
}
