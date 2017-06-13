package ua.room414.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
public enum  Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Gender getGender(String name) {
        for(Gender v : values()) {
            if (v.getName().equalsIgnoreCase(name)) {
                return v;
            }
        }
        return Gender.UNKNOWN;
    }

    @Override
    public String toString() {
        return name;
    }
}
