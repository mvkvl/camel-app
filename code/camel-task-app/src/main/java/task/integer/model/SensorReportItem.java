package task.integer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.io.Serializable;

//@Embeddable
@Entity
@Table(name = "report_data")
@JacksonXmlRootElement(localName = "data")
public class SensorReportItem implements Serializable {

    private static final long serialVersionUID = -7415410969017941320L;

    @Id
//    @GenericGenerator(name = "custom_report_item_id", strategy = "task.integer.jpa.CustomReportItemIdGenerator")
//    @GeneratedValue(generator = "custom_report_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @JsonIgnore
    public int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="report_id", foreignKey=@ForeignKey(name = "report_fk"))
    public SensorReport report;

    @JacksonXmlProperty(isAttribute = true)
    @Column(name="direction")
    public String direction;

    @JacksonXmlProperty(isAttribute = true)
    @Column(name="lane")
    public int lane;

    @JacksonXmlProperty(isAttribute = true)
    @Column(name="sensor_type")
    public String sensor_type;

    @Column(name="sensor_value")
    public String sensor_value;

    public void setReport(SensorReport report) {
        this.report = report;
    }

    public String toString() {
        return "direction: " + direction + "; lane: " + lane + "; type: " + sensor_type + "; value: " + sensor_value;
    }
}
