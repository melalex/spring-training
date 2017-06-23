package ua.room414.anotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 31 May 2017
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Facade {
    String value() default "";
}
