package ua.room414.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.room414.service.JmsPublisherService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Jun 2017
 */
@Component
public class JmsPublisherRunner implements CommandLineRunner {
    private static final String EXIT_MESSAGE = "q";

    private JmsPublisherService jmsPublisherService;

    @Autowired
    public JmsPublisherRunner(JmsPublisherService jmsPublisherService) {
        this.jmsPublisherService = jmsPublisherService;
    }

    @Override
    public void run(String... strings) throws Exception {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String message;

            do {
                System.out.print(">>> ");

                message = input.readLine();

                jmsPublisherService.publishMessage(message);
            } while (!message.equals(EXIT_MESSAGE));
        }
    }
}
