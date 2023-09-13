package block5logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Block5Application {
	private static final Logger logger = LogManager.getLogger(Block5Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Block5Application.class, args);

		logger.trace("Mensaje a nivel de TRACE");
		logger.debug("Mensaje a nivel de DEBUG");
		logger.info("Mensaje a nivel de INFO");
		logger.warn("Mensaje a nivel de WARNING");
		logger.error("Mensaje a nivel de ERROR");
		logger.error("Mensaje a nivel de ERROR");
		logger.error("Mensaje a nivel de ERROR");
		logger.error("Mensaje a nivel de ERROR");
		logger.error("Mensaje a nivel de ERROR");
		logger.error("Mensaje a nivel de ERROR");




	}

}
