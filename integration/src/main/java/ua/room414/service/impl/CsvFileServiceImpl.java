package ua.room414.service.impl;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import ua.room414.service.CsvFileService;

import java.util.Scanner;

import static ua.room414.FilesIntegrationConfiguration.FILE_HANDLER_INPUT_CHANEL;
import static ua.room414.FilesIntegrationConfiguration.FILE_WRITING_INPUT_CHANEL;

/**
 * @author Alexander Melashchenko
 * @version 1.0 12 Jun 2017
 */
@MessageEndpoint
public class CsvFileServiceImpl implements CsvFileService {

    @Override
    @ServiceActivator(inputChannel = FILE_HANDLER_INPUT_CHANEL, outputChannel = FILE_WRITING_INPUT_CHANEL)
    public String addFileNameToIds(@Payload final String payload, @Header(FileHeaders.FILENAME) final String fileName) {
        final StringBuilder result = new StringBuilder();

        try (final Scanner csvScanner = new Scanner(payload)) {

            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();

                result.append(line).append(fileName).append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}
