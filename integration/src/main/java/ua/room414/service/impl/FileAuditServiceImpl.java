package ua.room414.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ua.room414.service.FileAuditService;

import static ua.room414.FilesIntegrationConfiguration.DIRECTORY_PATH_HEADER;
import static ua.room414.FilesIntegrationConfiguration.FILE_WRITING_OUTPUT_CHANEL;

/**
 * @author Alexander Melashchenko
 * @version 1.0 12 Jun 2017
 */
@MessageEndpoint
public class FileAuditServiceImpl implements FileAuditService {
    private static final Logger LOG = LoggerFactory.getLogger(FileAuditServiceImpl.class);

    @Override
    @ServiceActivator(inputChannel = FILE_WRITING_OUTPUT_CHANEL)
    public void showSuccessWriteToFileMessage(
            @Header(DIRECTORY_PATH_HEADER) final String directoryPath,
            @Header(FileHeaders.FILENAME) final String fileName
    ) {
        final String message = String.format("Write to file %s in dir %s", fileName, directoryPath);
        LOG.info(message);
    }
}
