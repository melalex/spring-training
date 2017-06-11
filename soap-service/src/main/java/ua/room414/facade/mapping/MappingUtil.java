package ua.room414.facade.mapping;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 11 Jun 2017
 */
final public class MappingUtil {

    private MappingUtil() {

    }

    public static String mapLocalDateTime(LocalDateTime source) {
        return source.toString();
    }

    public static LocalDateTime reverseMapLocalDateTime(String source) {
        return LocalDateTime.parse(source);
    }
}
