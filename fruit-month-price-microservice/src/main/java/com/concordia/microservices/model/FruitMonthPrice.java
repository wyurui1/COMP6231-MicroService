package com.concordia.microservices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`fruit_month_price`")
public class FruitMonthPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`", nullable = false)
    private String name;

    @Column(name = "`month`", nullable = false)
    private String month;

    @Column(name = "`price`", nullable = false)
    private float price;

    @Column(name = "`environment`")
    private String environment;

    public FruitMonthPrice() {

    }

    public FruitMonthPrice(String name, String month, float price) {
        this.name = name;
        this.month = month;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
