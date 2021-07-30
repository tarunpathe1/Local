package com.spring.V1.gateway;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

import ch.qos.logback.classic.selector.servlet.LoggerContextFilter;
import reactor.core.publisher.Mono;

public class LoggingFilter implements GlobalFilter{
	
private org.slf4j.Logger logger= LoggerFactory.getLogger(LoggerContextFilter.class);
	

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path of the request recieved ->{}",exchange.getRequest().getPath());
		
		return chain.filter(exchange);
	}

}
