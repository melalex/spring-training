package ua.room414.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private String url;
    private String name;
    private Gender gender;
    private String culture;
    private String born;
    private String died;

    private List<String> titles;
    private List<String> aliases;

    private String father;
    private String mather;
    private String spouse;

    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBy;
}
