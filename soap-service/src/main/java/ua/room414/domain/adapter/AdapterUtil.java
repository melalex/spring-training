package ua.room414.domain.adapter;

import java.time.LocalDateTime;

/**
 * @author Alexander Melashchenko
 * @version 1.0 03 Jun 2017
 */
final class AdapterUtil {
    private AdapterUtil() {
    }

    static String marshalLocalDateTime(LocalDateTime dateTime) {
        return dateTime.toString();
    }

    static LocalDateTime unmarshalLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime);
    }
}
