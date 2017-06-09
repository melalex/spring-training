package ua.room414.domain.entity;

import ua.room414.domain.adapter.AuditoriumDatetimeMapAdapter;
import ua.room414.domain.adapter.LocalDateTimeSetAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Entity
@XmlRootElement
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

    @XmlJavaTypeAdapter(LocalDateTimeSetAdapter.class)
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

    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    @XmlElement(name = "auditoriums")
    @XmlJavaTypeAdapter(AuditoriumDatetimeMapAdapter.class)
    @ElementCollection
    @MapKeyColumn(name="airDatetime")
    @CollectionTable(name="datetimeAuditoriumMap", joinColumns=@JoinColumn(name="event_id"))
    public Map<LocalDateTime, Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Map<LocalDateTime, Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (Double.compare(event.basePrice, basePrice) != 0) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (airDates != null ? !airDates.equals(event.airDates) : event.airDates != null) return false;
        if (rating != event.rating) return false;
        return auditoriums != null ? auditoriums.equals(event.auditoriums) : event.auditoriums == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (airDates != null ? airDates.hashCode() : 0);
        temp = Double.doubleToLongBits(basePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (auditoriums != null ? auditoriums.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airDates=" + airDates +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", auditoriums=" + auditoriums +
                '}';
    }
}
