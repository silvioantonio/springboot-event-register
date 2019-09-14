package com.silvio.eventospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "repository")
@SpringBootApplication
public class EventospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventospringApplication.class, args);
	}

}
