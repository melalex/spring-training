package ua.room414.facade.dto;

import com.google.common.collect.ImmutableList;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 19 Jun 2017
 */
@ToString
@EqualsAndHashCode
@XmlRootElement
public class TicketList implements Serializable {
    private static final long serialVersionUID = -5901012937995125447L;

    private List<TicketDto> tickets;

    public static TicketList of(Iterable<TicketDto> auditoriums) {
        TicketList ticketList = new TicketList();
        ticketList.setAuditoriums(auditoriums);

        return ticketList;
    }

    public List<TicketDto> getAuditoriums() {
        return tickets;
    }

    public void setAuditoriums(Iterable<TicketDto> tickets) {
        this.tickets = ImmutableList.copyOf(tickets);
    }
}
