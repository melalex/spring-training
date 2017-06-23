package ua.room414.domain;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event implements Serializable {
    private static final long serialVersionUID = 6358073226117407034L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @ElementCollection
    @Temporal(TemporalType.TIMESTAMP)
    @CollectionTable(name = "air_date", joinColumns = @JoinColumn(name = "event_id"))
    private Set<DateTime> airDates;

    @Column(name = "base_price")
    private double basePrice;

    @Enumerated(EnumType.STRING)
    private EventRating rating;

    @ElementCollection
    @MapKeyColumn(name = "airDatetime")
    @Temporal(TemporalType.TIMESTAMP)
    @CollectionTable(name = "datetimeAuditoriumMap", joinColumns = @JoinColumn(name = "event_id"))
    private Map<DateTime, Auditorium> auditoriums;

}
