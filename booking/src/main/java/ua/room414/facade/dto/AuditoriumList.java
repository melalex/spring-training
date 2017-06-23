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
public class AuditoriumList implements Serializable {
    private static final long serialVersionUID = -1402764797170656003L;

    private List<AuditoriumDto> auditoriums;

    public static AuditoriumList of(Iterable<AuditoriumDto> auditoriums) {
        AuditoriumList auditoriumList = new AuditoriumList();
        auditoriumList.setAuditoriums(auditoriums);

        return auditoriumList;
    }

    public List<AuditoriumDto> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Iterable<AuditoriumDto> auditoriums) {
        this.auditoriums = ImmutableList.copyOf(auditoriums);
    }
}
