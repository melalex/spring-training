package ua.room414;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Serializable;

/**
 * @author Alexander Melashchenko
 * @version 1.0 12 Jun 2017
 */
@Component
@ConfigurationProperties(prefix = "path")
public final class FileIntegrationProperties implements Serializable {
    private static final long serialVersionUID = 1625053704998603618L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileIntegrationProperties that = (FileIntegrationProperties) o;

        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (processing != null ? !processing.equals(that.processing) : that.processing != null) return false;
        if (complete != null ? !complete.equals(that.complete) : that.complete != null) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        return regexp != null ? regexp.equals(that.regexp) : that.regexp == null;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (processing != null ? processing.hashCode() : 0);
        result = 31 * result + (complete != null ? complete.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + (regexp != null ? regexp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileIntegrationProperties{" +
                "source=" + source +
                ", processing=" + processing +
                ", complete=" + complete +
                ", error=" + error +
                ", regexp='" + regexp + '\'' +
                '}';
    }
}
