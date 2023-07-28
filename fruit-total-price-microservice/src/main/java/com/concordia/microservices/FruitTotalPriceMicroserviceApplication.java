package com.concordia.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FruitTotalPriceMicroserviceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.import", "optional:configserver:http://localhost:8888");
		SpringApplication.run(FruitTotalPriceMicroserviceApplication.class, args);
	}
}
