package com.aashita.consulting;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AashitaconsultingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AashitaconsultingApplication.class, args);
		System.out.println("Aashita Consulting App - started : " + Instant.now());
		HealthCheck.appDuration();
	}

}
