package ua.room414.facade.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@Data
@XmlRootElement
public class TicketDto {
    private long id;
    private UserDto user;
    private EventDto event;
    private LocalDateTime dateTime;
    private long seat;
}
