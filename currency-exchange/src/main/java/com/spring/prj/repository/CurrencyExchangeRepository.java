package com.spring.prj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.prj.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromAndTo(String from,String to);
}
