package ua.room414.facade.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ua.room414.domain.Auditorium;
import ua.room414.facade.dto.EventDto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Component
public class AuditoriumsReverseConverter extends AbstractConverter<EventDto.AdaptedMap, Map<LocalDateTime, Auditorium>> {

    @Override
    protected Map<LocalDateTime, Auditorium> convert(EventDto.AdaptedMap source) {
        return null;
    }
}
