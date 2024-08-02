package com.senacen.Unidle;


import com.senacen.Unidle.run.Location;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.senacen.Unidle.run.Run;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class UnidleApplication {

	private static final Logger log = LoggerFactory.getLogger(UnidleApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UnidleApplication.class, args);

		/*
		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		System.out.println(welcomeMessage);
		*/

		// log.info("Application started successfully");



	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOORS);
			log.info("Run: " + run);
		};

	}

}
