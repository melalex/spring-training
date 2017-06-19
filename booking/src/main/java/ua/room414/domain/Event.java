package ua.room414.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Entity
@ToString
@EqualsAndHashCode
public class Event implements Serializable {
    private static final long serialVersionUID = 6358073226117407034L;

    private long id;
    private String name;
    private Set<LocalDateTime> airDates;
    private double basePrice;
    private EventRating rating;
    private Map<LocalDateTime, Auditorium> auditoriums;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ElementCollection
    @CollectionTable(name = "airDate", joinColumns = @JoinColumn(name = "event_id"))
    public Set<LocalDateTime> getAirDates() {
        return airDates;
    }

    public void setAirDates(Set<LocalDateTime> airDates) {
        this.airDates = airDates;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Enumerated(EnumType.STRING)
    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    @ElementCollection
    @MapKeyColumn(name="airDatetime")
    @CollectionTable(name="datetimeAuditoriumMap", joinColumns=@JoinColumn(name="event_id"))
    public Map<LocalDateTime, Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Map<LocalDateTime, Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}
