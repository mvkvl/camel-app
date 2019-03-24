package task.integer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "report")
@JacksonXmlRootElement(localName = "report")
public class SensorReport implements Serializable {

    private static final long serialVersionUID = -7415410969017941321L;

    @JacksonXmlProperty(isAttribute = true)
    @Id
    @Column(name="id")
    public int id;

    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "datetime", columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    public Date datetime;

    @JacksonXmlProperty(isAttribute = true)
    @Column(name="period")
    public int period;

    @JacksonXmlElementWrapper(useWrapping = false)
    @OneToMany(mappedBy="report", cascade = CascadeType.ALL)
    public List<SensorReportItem> data;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id).append("; dt: ")
          .append(datetime).append("; period: ").append(period).append(" [")
          .append(String.join(", ", data.stream().map(v -> v.toString()).collect(Collectors.toList())))
          .append("]");
        return sb.toString();
    }

}
