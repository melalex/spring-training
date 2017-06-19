package ua.room414.facade.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
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
    private AdaptedMap auditoriums;

    @Data
    public static class AdaptedMap {
        private List<AdaptedMapEntry> content;
    }

    @Data
    public static class AdaptedMapEntry {
        private String key;
        private AuditoriumDto auditorium;
    }
}
