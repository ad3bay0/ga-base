package com.ad3bay0.gatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GaTestApp {

	public static void main(String[] args) {
		SpringApplication.run(GaTestApp.class, args);
	}

}
