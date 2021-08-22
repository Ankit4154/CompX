package com.compx;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class RyzenProcessor implements Processor, InitializingBean, DisposableBean {

	// private field for the dependency
	private GameService gameService;
	private String name;
	private Cache cache;
	
	// dependency injection by type
	@Autowired
	private MessageSource messageSource;

	// no-arg constructor for setter injection
	public RyzenProcessor() {
		System.out.println("No arg constructor " + this);
	}

	// constructor for dependency injection
	public RyzenProcessor(GameService gameService) {
		this.gameService = gameService;
	}

	// setter method
	public void setGameService(GameService gameService) {
		System.out.println("setter method " + gameService);
		this.gameService = gameService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getProcessorName() {
		return this.messageSource.getMessage("ryzen.processor", null, "Default Ryzen 3 3200g", null);
	}

	@Override
	public String getSupportedMotherboard() {
		// Use Game service to get supported names
		return gameService.getSupportedGames();
	}

	// same as destroy from InitializingBean interface
	public void myInit() {
		System.out.println("My Init method for bean");
	}

	// same as destroy from DisposableBean interface
	public void myDestroy() {
		System.out.println("My Destroy method for bean");
	}

	// same as Post processor, from JSR-250 annotations
	@PostConstruct
	public void myInit2() {
		System.out.println("myInit2 method via annotation PostContruct");
	}

	// same as Post processor, from JSR-250 annotations
	@PreDestroy
	public void myDestroy2() {
		System.out.println("myDestroy2 method via annotation PreDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method from InitializingBean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method from DisposableBean");
	}

	public Cache getCache() {
		return cache;
	}

	// Resource annotation from JSR-250 annotations
	@Resource(name = "cache")
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
