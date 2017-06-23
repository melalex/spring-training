package ua.room414.facade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Data
@NoArgsConstructor
@XmlRootElement
public class TicketDto implements Serializable {
    private static final long serialVersionUID = -2830163140972291538L;

    private long id;
    private UserDto user;
    private EventDto event;
    private String dateTime;
    private long seat;
}
