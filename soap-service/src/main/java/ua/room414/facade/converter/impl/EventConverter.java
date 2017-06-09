package ua.room414.facade.converter.impl;

import com.google.common.collect.Maps;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.room414.domain.entity.Auditorium;
import ua.room414.domain.entity.Event;
import ua.room414.dto.AuditoriumDto;
import ua.room414.dto.EventDto;
import ua.room414.dto.XmlMapEntry;
import ua.room414.dto.XmlMapWrapper;
import ua.room414.facade.converter.Converter;
import ua.room414.facade.mapping.MappingUtil;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
@Component
public class EventConverter implements Converter<Event, EventDto> {
    private ModelMapper modelMapper;

    @Autowired
    public EventConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EventDto convert(Event object) {
        EventDto eventDto = modelMapper.map(object, EventDto.class);

        eventDto.setAuditoriumDtos(mapAuditoriums(object.getAuditoriums()));

        return eventDto;
    }

    @Override
    public Event reverse(EventDto object) {
        Event event = modelMapper.map(object, Event.class);

        event.setAuditoriums(reverseMapAuditoriums(object.getAuditoriumDtos()));

        return event;
    }

    private XmlMapWrapper mapAuditoriums(Map<LocalDateTime, Auditorium> auditoriums) {
        XmlMapWrapper xmlMapWrapper = new XmlMapWrapper();

        Set<XmlMapEntry> content = auditoriums.entrySet().stream().map(e -> {
            XmlMapEntry xmlMapEntry = new XmlMapEntry();
            xmlMapEntry.setKey(MappingUtil.mapLocalDateTime(e.getKey()));
            xmlMapEntry.setValue(modelMapper.map(e.getValue(), AuditoriumDto.class));
            return xmlMapEntry;
        }).collect(Collectors.toSet());

        xmlMapWrapper.getContent().addAll(content);

        return xmlMapWrapper;
    }

    private Map<LocalDateTime, Auditorium> reverseMapAuditoriums(XmlMapWrapper auditoriumDtos) {
        Map<LocalDateTime, Auditorium> result = Maps.newHashMap();

        for (XmlMapEntry xmlMapEntry : auditoriumDtos.getContent()) {
            result.put(
                    MappingUtil.reverseMapLocalDateTime(xmlMapEntry.getKey()),
                    modelMapper.map(xmlMapEntry.getValue(), Auditorium.class)
            );
        }

        return result;
    }
}
