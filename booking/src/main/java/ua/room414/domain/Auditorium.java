package ua.room414.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "auditorium")
public class Auditorium implements Serializable {
    private static final long serialVersionUID = 8913787890825421432L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(name = "number_of_seats")
    private long numberOfSeats;

    @ElementCollection
    @CollectionTable(name = "vip_seats", joinColumns = @JoinColumn(name = "auditorium_id"))
    private Set<Integer> vipSeats;

}
