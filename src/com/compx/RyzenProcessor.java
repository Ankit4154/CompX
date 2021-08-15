package com.compx;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class RyzenProcessor implements Processor, InitializingBean, DisposableBean {

	// private field for the dependency
	private GameService gameService;

	// no-arg constructor for setter injection
	public RyzenProcessor() {
		System.out.println("No arg constructor " + this);
	}

	// setter method
	public void setGameService(GameService gameService) {
		System.out.println("setter method " + gameService);
		this.gameService = gameService;
	}

	// constructor for dependency injection
	public RyzenProcessor(GameService gameService) {
		this.gameService = gameService;
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
	
	public void myInit() {
		System.out.println("My Init method for bean");
	}
	
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
}
