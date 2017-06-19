package ua.room414.facade.dto;

import lombok.Data;
import ua.room414.domain.Gender;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@Data
public class CharacterDetailsDto {
    private long id;

    private String name;
    private Gender gender;
    private String culture;
    private String born;
    private String died;

    private List<String> titles;
    private List<String> aliases;

    private FamilyMember father;
    private FamilyMember mather;
    private FamilyMember spouse;

    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBy;

    @Data
    public static class FamilyMember {
        private long id;
        private String name;
    }
}
