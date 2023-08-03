package com.concordia.microservices.model;

public class FruitTotalPrice {

    private Long id;
    private String fruit;
    private String month;
    private float fmp;
    private int quantity;
    private float totalPrice;
    private String environment;

    public FruitTotalPrice() {

    }

    public FruitTotalPrice(Long id, String fruit, String month, float fmp, int quantity, float totalPrice, String environment) {
        this.id = id;
    	this.fruit = fruit;
        this.month = month;
        this.fmp = fmp;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getFmp() {
        return fmp;
    }

    public void setFmp(float fmp) {
        this.fmp = fmp;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}