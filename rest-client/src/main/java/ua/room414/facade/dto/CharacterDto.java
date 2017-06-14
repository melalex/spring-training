package ua.room414.facade.dto;

import lombok.Data;
import ua.room414.domain.Gender;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Data
public class CharacterDto {
    private long id;

    private String name;
    private Gender gender;
    private String culture;
    private String born;
    private String died;
}
