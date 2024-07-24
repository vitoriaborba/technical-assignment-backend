package com.example.brewery_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BreweryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreweryBackendApplication.class, args);
	}
}
