package ua.room414.facade.mapping.converter;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import com.google.common.base.Strings;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Component
public class EmptyStringConverter extends ConverterConfigurerSupport<String, String> {
    private String NO_DATA_PLACEHOLDER = "N/A";

    @Override
    protected Converter<String, String> converter() {
        return new AbstractConverter<String, String>() {
            @Override
            protected String convert(String source) {
                return !Strings.isNullOrEmpty(source) ? source : NO_DATA_PLACEHOLDER;
            }
        };
    }
}
