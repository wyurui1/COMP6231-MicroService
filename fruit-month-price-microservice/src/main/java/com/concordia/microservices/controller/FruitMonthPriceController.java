package com.concordia.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.concordia.microservices.data.InsertExcelFile;
import com.concordia.microservices.model.FruitMonthPrice;
import com.concordia.microservices.repository.FruitMonthPriceRepository;

@RestController
public class FruitMonthPriceController {
	@Autowired
	private Environment environment;

	@Autowired
	private FruitMonthPriceRepository repository;
	
	FruitMonthPriceController() {
		new InsertExcelFile("src/main/resources/static/FMP.xlsx");
	}
	
    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}")
    public FruitMonthPrice retrieveExchangeValue(
    		@PathVariable String fruit, 
    		@PathVariable String month) {    	
    	
    	//String capitalizedFruit = fruit.substring(0, 1).toUpperCase() + fruit.substring(1);
    	//String capitalizedMonth = month.substring(0, 1).toUpperCase() + month.substring(1,3);
    	
    	String fruitName = fruit.toLowerCase();
		String monthName = month.toLowerCase();
    	if (month.length() > 2) {
    		monthName = month.toLowerCase().substring(0,3);
    	}

    	FruitMonthPrice priceEntity = repository.findByFruitIgnoreCaseAndMonthIgnoreCase(fruitName, monthName);
    	if(priceEntity == null) {
    		throw new RuntimeException("Unable to find data for " + fruit + " in " + month);
    	}
    	
    	String port = environment.getProperty("local.server.port");
    	priceEntity.setEnvironment(port);
    	return priceEntity;
    }
    
    @GetMapping("/fruit-month-price/test")
    public FruitMonthPrice retrieveExchangeValue() {    	
    	System.out.print("Success\n");
    	return new FruitMonthPrice("test1","testmonth",323);
    }
}