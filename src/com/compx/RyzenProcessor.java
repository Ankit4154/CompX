package com.compx;

public class RyzenProcessor implements Processor {

	// private field for the dependency
	private GameService gameSer;

	// constructor for dependency injection
	public RyzenProcessor(GameService gameSerRef) {
		gameSer = gameSerRef;
	}

	@Override
	public String getProcessorName() {
		return "Ryzen 3 3200g";
	}

	@Override
	public String getSupportedMotherboard() {
		// Use Game service to get supported names
		return gameSer.getSupportedGames();
	}

}
