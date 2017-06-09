package ua.room414.domain.adapter;

import ua.room414.domain.entity.Auditorium;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 02 Jun 2017
 */
@XmlRootElement(name = "map")
public class XmlMapWrapper {
    private Set<XmlMapEntry> content;

    @XmlRootElement(name = "entry")
    static class XmlMapEntry {
        private String key;
        private Auditorium value;

        public XmlMapEntry() {
        }

        XmlMapEntry(String key, Auditorium value) {
            this.key = key;
            this.value = value;
        }

        static XmlMapEntry valueOf(Map.Entry<LocalDateTime, Auditorium> entry) {
            return new XmlMapEntry(AdapterUtil.marshalLocalDateTime(entry.getKey()), entry.getValue());
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Auditorium getValue() {
            return value;
        }

        public void setValue(Auditorium value) {
            this.value = value;
        }
    }

    private XmlMapWrapper() {

    }

    static XmlMapWrapper valueOf(Map<LocalDateTime, Auditorium> map) {
        XmlMapWrapper newInstance = new XmlMapWrapper();

        newInstance.content = map.entrySet().stream()
                .map(XmlMapEntry::valueOf)
                .collect(Collectors.toSet());

        return newInstance;
    }

    public Set<XmlMapEntry> getContent() {
        return content;
    }

    public void setContent(Set<XmlMapEntry> content) {
        this.content = content;
    }
}
