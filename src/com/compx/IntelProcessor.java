package com.compx;

public class IntelProcessor implements Processor {

	// private field for the dependency
	private GameService gameSer;
	private String name;

	public IntelProcessor() {

	}

	// constructor for dependency injection
	public IntelProcessor(GameService gameSerRef) {
		gameSer = gameSerRef;
	}

	@Override
	public String getProcessorName() {
		return "Intel i3 9100F";
	}

	@Override
	public String getSupportedMotherboard() {
		return gameSer.getSupportedGames();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
