package ua.room414.domain.adapter;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 07 Jun 2017
 */
public class XmlSetWrapper {
    private Set<String> content;

    public XmlSetWrapper() {
    }

    public XmlSetWrapper(Set<String> content) {
        this.content = content;
    }

    public Set<String> getContent() {
        return content;
    }

    public void setContent(Set<String> content) {
        this.content = content;
    }
}
