package ua.room414.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Entity
@ToString
@EqualsAndHashCode
public class Auditorium implements Serializable {
    private static final long serialVersionUID = 8913787890825421432L;

    private long id;
    private String name;
    private long numberOfSeats;
    private Set<Integer> vipSeats;

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

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @ElementCollection
    @CollectionTable(name = "vip_seats", joinColumns = @JoinColumn(name = "auditorium_id"))
    public Set<Integer> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(Set<Integer> vipSeats) {
        this.vipSeats = vipSeats;
    }
}
