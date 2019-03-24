package task.integer.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import task.integer.jpa.SensorReportRepository;
import task.integer.model.SensorReport;

//@Component
public class SensorReportProcessor implements Processor {

    @Autowired
    private SensorReportRepository sensorReportRepository;

    public void process(Exchange exchange) throws Exception {
        SensorReport report = exchange.getIn().getBody(SensorReport.class);
        if (report == null || report.data == null)
            // some additional checks can be added here in case of need
            throw new Exception("incorrect data received");

        // set 'report' field for reportItems to satisfy DB relations
        // should be done before persist attempt
        report.data.stream().forEach(v -> v.setReport(report));
        sensorReportRepository.save(report);
    }
}
