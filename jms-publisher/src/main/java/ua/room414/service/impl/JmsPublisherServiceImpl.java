package ua.room414.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ua.room414.service.JmsPublisherService;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Jun 2017
 */
@Component
public class JmsPublisherServiceImpl implements JmsPublisherService {
    private JmsTemplate jmsTemplate;

    @Value("${jms.destination.name}")
    private String destinationName;

    @Autowired
    public JmsPublisherServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void publishMessage(String message) {
            jmsTemplate.convertAndSend(destinationName, message);
    }
}
