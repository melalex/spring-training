package ua.room414.domain.adapter;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 02 Jun 2017
 */
@Component
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return AdapterUtil.unmarshalLocalDateTime(v);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return AdapterUtil.marshalLocalDateTime(v);
    }
}
