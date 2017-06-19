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
public class AuditoriumsConverter extends AbstractConverter<Map<LocalDateTime, Auditorium>, EventDto.AdaptedMap> {

    @Override
    protected EventDto.AdaptedMap convert(Map<LocalDateTime, Auditorium> source) {
        return null;
    }
}
