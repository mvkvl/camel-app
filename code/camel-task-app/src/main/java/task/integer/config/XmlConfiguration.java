package task.integer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("file:./config/camel-context.xml")
public class XmlConfiguration {
}