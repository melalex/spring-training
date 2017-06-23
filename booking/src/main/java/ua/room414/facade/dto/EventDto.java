package ua.room414.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.room414.facade.adapters.MapAdapter;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Data
@NoArgsConstructor
@XmlRootElement
public class EventDto implements Serializable {
    private static final long serialVersionUID = -3217751532301510078L;

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
    public static class AdaptedMap implements Serializable {
        private static final long serialVersionUID = 2005282446500141045L;

        private List<AdaptedMapEntry> content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdaptedMapEntry implements Serializable {
        private static final long serialVersionUID = 5802180329888827274L;

        private String key;
        private AuditoriumDto auditorium;
    }
}
