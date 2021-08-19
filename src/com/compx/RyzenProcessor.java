package com.compx;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class RyzenProcessor implements Processor, InitializingBean, DisposableBean {

	// private field for the dependency
	private GameService gameService;
	private String name;
	private Cache cache;

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
		return "Ryzen 3 3200g";
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

	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
