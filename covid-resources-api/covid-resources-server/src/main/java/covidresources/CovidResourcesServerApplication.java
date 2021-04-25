package covidresources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import covidresources.controller.LeadsController;

@SpringBootApplication
public class CovidResourcesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidResourcesServerApplication.class, args);
	}

}
