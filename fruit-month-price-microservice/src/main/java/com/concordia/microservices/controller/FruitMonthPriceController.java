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
		new InsertExcelFile("src/main/resources/FMP.xlsx");
	}
	
    @GetMapping("/fruit-month-price/fruit/{name}/month/{month}")
    public FruitMonthPrice retrieveExchangeValue(
    		@PathVariable String name, 
    		@PathVariable String month) {    	
    	
    	FruitMonthPrice priceEntity = repository.findByNameIgnoreCaseAndMonthIgnoreCase(name, month);
    	if(priceEntity == null) {
    		throw new RuntimeException("Unable to find data for " + name + " in " + month);
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