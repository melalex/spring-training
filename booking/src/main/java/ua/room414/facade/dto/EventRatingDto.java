package ua.room414.facade.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@XmlEnum
@XmlType(name = "eventRating")
public enum EventRatingDto {
    LOW("low"),
    MID("mid"),
    HIGH("high");

    private String name;

    EventRatingDto(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static EventRatingDto getEventRatingDto(String name) {
        for (EventRatingDto v : values()) {
            if (v.getName().equalsIgnoreCase(name)) {
                return v;
            }
        }
        throw new IllegalArgumentException("There is no EventRatingDto with name '" + name + "'");
    }

    @Override
    public String toString() {
        return name;
    }
}
