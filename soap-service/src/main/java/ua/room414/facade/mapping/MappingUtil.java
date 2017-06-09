package ua.room414.facade.mapping;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
public final class MappingUtil {

    private MappingUtil() {

    }

    public static String mapLocalDateTime(LocalDateTime dateTime) {
        return dateTime.toString();
    }

    public static LocalDateTime reverseMapLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime);
    }
}
