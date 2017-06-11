package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Auditorium;
import ua.room414.dto.AuditoriumDto;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Component
public class AuditoriumPropertyMap extends PropertyMapConfigurerSupport<Auditorium, AuditoriumDto> {

    @Override
    public PropertyMap<Auditorium, AuditoriumDto> mapping() {
        final Converter<Set<Long>, AuditoriumDto.VipSeats> vipSeatsConverter =
                ctx -> mapVipSeats(ctx.getSource());

        return new PropertyMap<Auditorium, AuditoriumDto>() {
            @Override
            protected void configure() {
                using(vipSeatsConverter).map(source.getVipSeats(), destination.getVipSeats());
            }
        };
    }

    private AuditoriumDto.VipSeats mapVipSeats(Set<Long> vipSeats) {
        AuditoriumDto.VipSeats result = new AuditoriumDto.VipSeats();

        result.getSeat().addAll(vipSeats);

        return result;
    }
}
