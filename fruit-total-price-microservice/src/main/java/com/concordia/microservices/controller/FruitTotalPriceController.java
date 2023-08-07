package com.concordia.microservices.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.concordia.microservices.model.FruitTotalPrice;


@RestController
public class FruitTotalPriceController {

    
    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}/quantity/{quantity}")
    public FruitTotalPrice retrieveExchangeValue(
    		@PathVariable String fruit, 
    		@PathVariable String month,
    		@PathVariable int quantity) {    	
    	
    	//String capitalizedFruit = fruit.substring(0, 1).toUpperCase() + fruit.substring(1);
    	//String capitalizedMonth = month.substring(0, 1).toUpperCase() + month.substring(1,3);
    	String fruitName = fruit.toLowerCase();
		String monthName = month.toLowerCase();
    	if (month.length() > 2) {
    		monthName = month.toLowerCase().substring(0,3);
    	}
    	
    	HashMap<String, String> uriVariables = new HashMap<>();
    	uriVariables.put("fruit", fruitName);
    	uriVariables.put("month", monthName);
    	
        String remoteUrl = "http://localhost:8000/fruit-month-price/fruit/{fruit}/month/{month}";
    	ResponseEntity<FruitTotalPrice> responseEntity = 
    			new RestTemplate().getForEntity(remoteUrl, FruitTotalPrice.class, uriVariables);

    	FruitTotalPrice fruitTotalPriceData = responseEntity.getBody();

    	fruitTotalPriceData.setQuantity(quantity);
    	fruitTotalPriceData.setTotalPrice(quantity * fruitTotalPriceData.getFmp());
    	return new FruitTotalPrice(fruitTotalPriceData.getId(), 
    			fruitName, monthName, 
    			fruitTotalPriceData.getFmp(),
    			quantity,
    			quantity * fruitTotalPriceData.getFmp(),
    			fruitTotalPriceData.getEnvironment());
    }
    
}