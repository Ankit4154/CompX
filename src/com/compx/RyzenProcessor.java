package com.compx;

public class RyzenProcessor implements Processor {

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

}
