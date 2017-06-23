package ua.room414.domain;


import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 5417639527858057871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime dateTime;

    private long seat;
}
