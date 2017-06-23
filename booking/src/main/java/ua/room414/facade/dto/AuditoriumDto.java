package ua.room414.facade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Data
@NoArgsConstructor
@XmlRootElement
public class AuditoriumDto implements Serializable{
    private static final long serialVersionUID = 6812076187896746399L;

    private long id;
    private String name;
    private long numberOfSeats;

    @XmlElementWrapper
    private Set<Long> vipSeats;
}
