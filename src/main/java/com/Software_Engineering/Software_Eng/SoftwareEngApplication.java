package com.Software_Engineering.Software_Eng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication()
@EnableJpaAuditing //BaseTimeEntity
public class SoftwareEngApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngApplication.class, args);
	}

}
