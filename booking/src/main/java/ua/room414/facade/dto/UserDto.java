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
public class UserDto implements Serializable {
    private static final long serialVersionUID = 9158156886864965L;

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthday;

    @XmlElementWrapper
    private Set<TicketDto> tickets;
}
