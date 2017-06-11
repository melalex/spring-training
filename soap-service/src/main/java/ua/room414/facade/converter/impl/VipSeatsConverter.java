package ua.room414.facade.converter.impl;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
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
public class VipSeatsConverter extends ConverterConfigurerSupport<Set<Long>, AuditoriumDto.VipSeats> {

    @Override
    protected Converter<Set<Long>, AuditoriumDto.VipSeats> converter() {
        return new AbstractConverter<Set<Long>, AuditoriumDto.VipSeats>() {

            @Override
            protected AuditoriumDto.VipSeats convert(Set<Long> source) {
                AuditoriumDto.VipSeats result = new AuditoriumDto.VipSeats();

                result.getSeat().addAll(source);

                return result;
            }
        };
    }
}
