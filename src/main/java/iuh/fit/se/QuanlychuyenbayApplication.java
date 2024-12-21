package iuh.fit.se;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuanlychuyenbayApplication {
	private final static Logger logger = LoggerFactory.getLogger(QuanlychuyenbayApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(QuanlychuyenbayApplication.class, args);
		logger.info("QuanlychuyenbayApplication start");
	}

}
