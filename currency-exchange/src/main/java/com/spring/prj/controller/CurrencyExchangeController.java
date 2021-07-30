package com.spring.prj.controller;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.prj.bean.CurrencyExchange;
import com.spring.prj.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired	
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to)
	{
		//CurrencyExchange currencyexchange = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		
		CurrencyExchange currencyexchange = repository.findByFromAndTo(from, to);
		if(currencyexchange==null)
		{
			throw new RuntimeException("Unable to find data for "+from+" and "+to);
		}
		
		String port=environment.getProperty("local.server.port");
		currencyexchange.setEnvironment(port);
		return currencyexchange;
		
		 
		
	}
	@PostMapping("/currency-exchange")
	public CurrencyExchange addCurrencyExhange(@RequestBody CurrencyExchange currency)
	{
		System.out.println(currency.toString());
		repository.save(currency);
		return currency;
	}
}
