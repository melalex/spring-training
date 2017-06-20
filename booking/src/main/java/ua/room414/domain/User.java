package ua.room414.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.joda.time.LocalDate;

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
public class User implements Serializable {
    private static final long serialVersionUID = 6700876374671429079L;

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private Set<Ticket> tickets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
