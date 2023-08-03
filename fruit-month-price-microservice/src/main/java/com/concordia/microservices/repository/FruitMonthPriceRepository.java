package com.concordia.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concordia.microservices.model.FruitMonthPrice;

public interface FruitMonthPriceRepository extends JpaRepository<FruitMonthPrice, Long> {
	FruitMonthPrice findByFruitIgnoreCaseAndMonthIgnoreCase(String fruit, String month);
}
