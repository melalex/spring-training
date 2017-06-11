package ua.room414.domain.adapter;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 03 Jun 2017
 */
public class LocalDateTimeSetAdapter extends XmlAdapter<XmlSetWrapper, Set<LocalDateTime>> {
    @Override
    public Set<LocalDateTime> unmarshal(XmlSetWrapper v) throws Exception {
        return v.getContent().stream()
                .map(AdapterUtil::unmarshalLocalDateTime)
                .collect(Collectors.toSet());
    }

    @Override
    public XmlSetWrapper marshal(Set<LocalDateTime> v) throws Exception {
        Set<String> content = v.stream()
                .map(AdapterUtil::marshalLocalDateTime)
                .collect(Collectors.toSet());

        return new XmlSetWrapper(content);
    }
}
