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
public class UserList implements Serializable {
    private static final long serialVersionUID = 253767074775087036L;

    private List<UserDto> users;

    public static UserList of(Iterable<UserDto> auditoriums) {
        UserList userList = new UserList();
        userList.setAuditoriums(auditoriums);

        return userList;
    }

    public List<UserDto> getAuditoriums() {
        return users;
    }

    public void setAuditoriums(Iterable<UserDto> users) {
        this.users = ImmutableList.copyOf(users);
    }
}
