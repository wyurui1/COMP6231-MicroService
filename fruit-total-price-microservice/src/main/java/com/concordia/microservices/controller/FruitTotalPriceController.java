package com.concordia.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.concordia.microservices.model.FruitTotalPrice;


@RestController
public class FruitTotalPriceController {

    
    @GetMapping("/fruit-month-price/fruit/{name}/month/{month}/quantity/{quantity}")
    public FruitTotalPrice retrieveExchangeValue(
    		@PathVariable String name, 
    		@PathVariable String month,
    		@PathVariable int quantity) {    	
    	
        String remoteUrl = "http://localhost:8080/fruit-month-price/fruit/" + name + "/month/" + month;

        RestTemplate restTemplate = new RestTemplate();
        FruitTotalPrice fruitTotalPriceData = restTemplate.getForObject(remoteUrl, FruitTotalPrice.class);
    	fruitTotalPriceData.setQuantity(quantity);
    	fruitTotalPriceData.setTotalPrice(quantity * fruitTotalPriceData.getPrice());
    	return fruitTotalPriceData;
    }
    
}