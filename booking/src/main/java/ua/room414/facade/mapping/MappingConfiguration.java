package ua.room414.facade.mapping;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.room414.domain.Auditorium;
import ua.room414.facade.dto.EventDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Configuration
public class MappingConfiguration {
    private Converter<Map<LocalDateTime, Auditorium>, EventDto.AdaptedMap> auditoriumsConverter;
    private Converter<EventDto.AdaptedMap, Map<LocalDateTime, Auditorium>> auditoriumsReverseConverter;

    private Converter<LocalDateTime, String> localDateTimeConverter;
    private Converter<String, LocalDateTime> localDateTimeReverseConverter;

    private Converter<LocalDate, String> localDateConverter;
    private Converter<String, LocalDate> localDateReverseConverter;

    @Autowired
    public void setAuditoriumsConverter(Converter<Map<LocalDateTime, Auditorium>, EventDto.AdaptedMap> auditoriumsConverter) {
        this.auditoriumsConverter = auditoriumsConverter;
    }

    @Autowired
    public void setAuditoriumsReverseConverter(Converter<EventDto.AdaptedMap, Map<LocalDateTime, Auditorium>> auditoriumsReverseConverter) {
        this.auditoriumsReverseConverter = auditoriumsReverseConverter;
    }

    @Autowired
    public void setLocalDateTimeConverter(Converter<LocalDateTime, String> localDateTimeConverter) {
        this.localDateTimeConverter = localDateTimeConverter;
    }

    @Autowired
    public void setLocalDateTimeReverseConverter(Converter<String, LocalDateTime> localDateTimeReverseConverter) {
        this.localDateTimeReverseConverter = localDateTimeReverseConverter;
    }

    @Autowired
    public void setLocalDateConverter(Converter<LocalDate, String> localDateConverter) {
        this.localDateConverter = localDateConverter;
    }

    @Autowired
    public void setLocalDateReverseConverter(Converter<String, LocalDate> localDateReverseConverter) {
        this.localDateReverseConverter = localDateReverseConverter;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(auditoriumsConverter);
        modelMapper.addConverter(auditoriumsReverseConverter);
        modelMapper.addConverter(localDateTimeConverter);
        modelMapper.addConverter(localDateTimeReverseConverter);
        modelMapper.addConverter(localDateConverter);
        modelMapper.addConverter(localDateReverseConverter);

        return modelMapper;
    }
}
