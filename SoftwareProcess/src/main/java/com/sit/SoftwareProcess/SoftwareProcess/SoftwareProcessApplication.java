package com.sit.SoftwareProcess.SoftwareProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoftwareProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareProcessApplication.class, args);
	}
}
