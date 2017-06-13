package ua.room414.facade.dto;

import lombok.Data;
import ua.room414.domain.Gender;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Data
public class FilterCharacterRequestDto {
    private int page;
    private String name;
    private Gender gender;
    private String culture;
    private String born;
    private String died;
    private boolean isAlive;
}
