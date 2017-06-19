package ua.room414.facade.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Data
@XmlRootElement
public class AuditoriumDto {
    private long id;
    private String name;
    private long numberOfSeats;

    @XmlElementWrapper
    private Set<Long> vipSeats;
}
