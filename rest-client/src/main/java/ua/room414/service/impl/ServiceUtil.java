package ua.room414.service.impl;

import lombok.experimental.UtilityClass;
import org.springframework.util.MultiValueMap;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Jun 2017
 */
@UtilityClass
class ServiceUtil {
    final String FAKE_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0";

    <V> void putIfCondition(final String key, final V value, final MultiValueMap<String, String> map, final Function<V, Boolean> condition) {
        if (condition.apply(value)) {
            map.add(key, Objects.toString(value));
        }
    }
}
