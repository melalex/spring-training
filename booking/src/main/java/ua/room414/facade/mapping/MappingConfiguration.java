package ua.room414.facade.mapping;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Configuration
public class MappingConfiguration {
    private Converter<LocalDateTime, String> localDateTimeConverter;
    private Converter<String, LocalDateTime> localDateTimeReverseConverter;

    private Converter<LocalDate, String> localDateConverter;
    private Converter<String, LocalDate> localDateReverseConverter;

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

        modelMapper.addConverter(localDateTimeConverter);
        modelMapper.addConverter(localDateTimeReverseConverter);
        modelMapper.addConverter(localDateConverter);
        modelMapper.addConverter(localDateReverseConverter);

        return modelMapper;
    }
}
