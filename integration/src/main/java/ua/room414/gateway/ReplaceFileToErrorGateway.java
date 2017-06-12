package ua.room414.gateway;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * @author Alexander Melashchenko
 * @version 1.0 09 Jun 2017
 */
@MessagingGateway
public interface ReplaceFileToErrorGateway {

    void writeToFile(String fileName);
}
