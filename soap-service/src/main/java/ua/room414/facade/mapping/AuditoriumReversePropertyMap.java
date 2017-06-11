package ua.room414.facade.mapping;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import com.google.common.collect.Sets;
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
public class AuditoriumReversePropertyMap extends PropertyMapConfigurerSupport<AuditoriumDto, Auditorium> {

    @Override
    public PropertyMap<AuditoriumDto, Auditorium> mapping() {
        final Converter<AuditoriumDto.VipSeats, Set<Long>> reverseVipSeatsConverter =
                ctx -> mapVipSeats(ctx.getSource());

        return new PropertyMap<AuditoriumDto, Auditorium>() {
            @Override
            protected void configure() {
                using(reverseVipSeatsConverter).map(source.getVipSeats(), destination.getVipSeats());
            }
        };
    }

    private Set<Long> mapVipSeats(AuditoriumDto.VipSeats vipSeats) {
        return Sets.newHashSet(vipSeats.getSeat());
    }
}
