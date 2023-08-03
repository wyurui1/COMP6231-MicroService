package com.concordia.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FruitMonthPriceMicroserviceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.import", "optional:configserver:http://localhost:8888");
		try {
            SpringApplication.run(FruitMonthPriceMicroserviceApplication.class, args);
        } catch (Exception e) {
        	if (e.getMessage() != null) {
        		System.err.println("An error occurs:" + e.getMessage());
        	}
        }
	}

}
