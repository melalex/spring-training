package ua.room414.domain.adapter;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Auditorium;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 02 Jun 2017
 */
public class AuditoriumDatetimeMapAdapter extends XmlAdapter<XmlMapWrapper, Map<LocalDateTime, Auditorium>> {

    @Override
    public Map<LocalDateTime, Auditorium> unmarshal(XmlMapWrapper v) throws Exception {
        Map<LocalDateTime, Auditorium> result = Maps.newHashMap();

        for (XmlMapWrapper.XmlMapEntry kvXmlMapEntry : v.getContent()) {
            result.put(AdapterUtil.unmarshalLocalDateTime(kvXmlMapEntry.getKey()), kvXmlMapEntry.getValue());
        }

        return result;
    }

    @Override
    public XmlMapWrapper marshal(Map<LocalDateTime, Auditorium> v) throws Exception {
       return XmlMapWrapper.valueOf(v);
    }
}
