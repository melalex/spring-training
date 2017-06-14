package ua.room414.domain;

import lombok.Data;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
@Data
public class FilterCharacterRequest {
    private int page;
    private String name;
    private Gender gender;
    private String culture;
    private String born;
    private String died;
    private Boolean isAlive;
}
