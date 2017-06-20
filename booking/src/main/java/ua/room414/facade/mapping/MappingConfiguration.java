package ua.room414.facade.mapping;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Configuration
public class MappingConfiguration {
    private Converter<DateTime, String> localDateTimeConverter;
    private Converter<String, DateTime> localDateTimeReverseConverter;

    private Converter<LocalDate, String> localDateConverter;
    private Converter<String, LocalDate> localDateReverseConverter;

    @Autowired
    public void setLocalDateTimeConverter(Converter<DateTime, String> localDateTimeConverter) {
        this.localDateTimeConverter = localDateTimeConverter;
    }

    @Autowired
    public void setLocalDateTimeReverseConverter(Converter<String, DateTime> localDateTimeReverseConverter) {
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
