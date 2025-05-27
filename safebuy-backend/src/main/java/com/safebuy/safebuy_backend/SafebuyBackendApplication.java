package com.safebuy.safebuy_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.safebuy.safebuy_backend.repository")
public class SafebuyBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(SafebuyBackendApplication.class, args);
	}
}
