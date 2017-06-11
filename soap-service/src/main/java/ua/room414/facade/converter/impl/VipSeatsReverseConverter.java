package ua.room414.facade.converter.impl;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import com.google.common.collect.Sets;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;
import ua.room414.dto.AuditoriumDto;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 11 Jun 2017
 */
@Component
public class VipSeatsReverseConverter extends ConverterConfigurerSupport<AuditoriumDto.VipSeats, Set<Long>> {

    @Override
    protected Converter<AuditoriumDto.VipSeats, Set<Long>> converter() {
        return new AbstractConverter<AuditoriumDto.VipSeats, Set<Long>>() {

            @Override
            protected Set<Long> convert(AuditoriumDto.VipSeats source) {
                return Sets.newHashSet(source.getSeat());
            }
        };
    }
}
