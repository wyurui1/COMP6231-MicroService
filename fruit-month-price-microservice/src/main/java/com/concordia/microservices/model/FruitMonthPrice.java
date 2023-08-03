package com.concordia.microservices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`fruit_month_price`")
public class FruitMonthPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`fruit`", nullable = false)
    private String fruit;

    @Column(name = "`month`", nullable = false)
    private String month;

    @Column(name = "`fmp`", nullable = false)
    private float fmp;

    @Column(name = "`environment`")
    private String environment;

    public FruitMonthPrice() {

    }

    public FruitMonthPrice(String fruit, String month, float fmp) {
        this.fruit = fruit;
        this.month = month;
        this.fmp = fmp;
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
}
