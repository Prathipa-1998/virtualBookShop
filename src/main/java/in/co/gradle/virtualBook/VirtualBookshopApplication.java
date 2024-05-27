package in.co.gradle.virtualBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VirtualBookshopApplication {
	private static final Logger logger= LoggerFactory.getLogger(VirtualBookshopApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(VirtualBookshopApplication.class, args);
		logger.info("Springboot application started");
	}
	

}
