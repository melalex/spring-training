package ua.room414.facade.adapters;

import com.google.common.collect.ImmutableList;
import ua.room414.facade.dto.AuditoriumDto;
import ua.room414.facade.dto.EventDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
public class MapAdapter extends XmlAdapter<EventDto.AdaptedMap, Map<String, AuditoriumDto>> {

    @Override
    public Map<String, AuditoriumDto> unmarshal(EventDto.AdaptedMap v) throws Exception {
        return v.getContent()
                .stream()
                .collect(Collectors.toMap(EventDto.AdaptedMapEntry::getKey, EventDto.AdaptedMapEntry::getAuditorium));
    }

    @Override
    public EventDto.AdaptedMap marshal(Map<String, AuditoriumDto> v) throws Exception {
        List<EventDto.AdaptedMapEntry> content = v
                .entrySet()
                .stream()
                .map(e -> new EventDto.AdaptedMapEntry(e.getKey(), e.getValue()))
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        return new EventDto.AdaptedMap(content);
    }
}
