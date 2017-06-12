package ua.room414;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author Alexander Melashchenko
 * @version 1.0 12 Jun 2017
 */
@Component
@ConfigurationProperties(prefix = "path")
public final class FileIntegrationProperties {
    private File source;
    private File processing;
    private File complete;
    private File error;
    private String regexp;


    public File getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = new File(source);
    }

    public File getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = new File(processing);
    }

    public File getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = new File(complete);
    }

    public File getError() {
        return error;
    }

    public void setError(String error) {
        this.error = new File(error);
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }
}
