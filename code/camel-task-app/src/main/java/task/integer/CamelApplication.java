package task.integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableAutoConfiguration
public class CamelApplication {

	private static final Logger logger = LoggerFactory.getLogger("task.integer.app");

	@EventListener(classes = {ContextRefreshedEvent.class})
	private void handleContextStartedEvent(ContextRefreshedEvent ctxStartEvt) {
		logger.info(" >>> starting up integration application");
	}

	@EventListener(classes = {ContextClosedEvent.class})
	private void handleContextClosedEvent(ContextClosedEvent ctxCloseEvt) {
		logger.info(" >>> shutting down integration application");
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return new CamelApplicationRunner();
//	}

	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);
	}

}
