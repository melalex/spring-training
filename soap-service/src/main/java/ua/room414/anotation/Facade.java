package ua.room414.anotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 04 Jun 2017
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Facade {
    String value() default "";
}