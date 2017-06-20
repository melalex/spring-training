package ua.room414.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.room414.domain.Auditorium;
import ua.room414.facade.adapters.MapAdapter;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Data
@XmlRootElement
public class EventDto {
    private long id;
    private String name;

    @XmlElementWrapper
    private Set<String> airDates;
    private double basePrice;
    private EventRatingDto rating;

    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map<String, AuditoriumDto> auditoriums;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdaptedMap {
        private List<AdaptedMapEntry> content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdaptedMapEntry {
        private String key;
        private AuditoriumDto auditorium;
    }
}
