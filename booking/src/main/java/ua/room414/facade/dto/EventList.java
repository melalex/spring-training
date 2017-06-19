package ua.room414.facade.dto;

import com.google.common.collect.ImmutableList;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@ToString
@EqualsAndHashCode
@XmlRootElement
public class EventList {
    private List<EventDto> events;

    public static EventList of(Iterable<EventDto> auditoriums) {
        EventList eventList = new EventList();
        eventList.setAuditoriums(auditoriums);

        return eventList;
    }

    public List<EventDto> getAuditoriums() {
        return events;
    }

    public void setAuditoriums(Iterable<EventDto> events) {
        this.events = ImmutableList.copyOf(events);
    }

}
