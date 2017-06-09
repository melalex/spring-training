package ua.room414.facade.mapping;

import com.google.common.collect.Sets;
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
public class AuditoriumReversePropertyMap extends PropertyMap<AuditoriumDto, Auditorium> {

    @Override
    protected void configure() {
        map().setVipSeats(mapVipSeats(source.getVipSeats()));
    }

    private Set<Long> mapVipSeats(AuditoriumDto.VipSeats vipSeats) {
        return Sets.newHashSet(vipSeats.getSeat());
    }

}
