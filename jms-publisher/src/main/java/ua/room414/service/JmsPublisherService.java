package ua.room414.service;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Jun 2017
 */
public interface JmsPublisherService {

    void publishMessage(String message);
}
