package ua.room414;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Jun 2017
 */
@Component
@Slf4j
public class Receiver {

    @JmsListener(destination = "jms-training")
    public void receiveMessage(String message) {
        log.info(message);
    }
}
