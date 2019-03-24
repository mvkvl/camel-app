package task.integer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import task.integer.jpa.SensorReportRepository;
import task.integer.model.SensorReport;

import java.io.*;

public class CamelApplicationRunner implements CommandLineRunner {

    private static final String INPUT_FILE = "/opt/dev/task/integer/data/input.test/test.xml";

    @Autowired
    private SensorReportRepository sensorReportRepository;

    @Override
    public void run(String... args) throws Exception {

        File file = new File(INPUT_FILE);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        SensorReport value = xmlMapper.readValue(xml, SensorReport.class);

        System.out.println(value);
        sensorReportRepository.save(value);

    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
