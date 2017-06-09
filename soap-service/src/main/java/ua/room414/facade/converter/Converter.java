package ua.room414.facade.converter;

/**
 * @author Alexander Melashchenko
 * @version 1.0 08 Jun 2017
 */
public interface Converter<S, D> {
    D convert(S object);

    S reverse(D object);
}
