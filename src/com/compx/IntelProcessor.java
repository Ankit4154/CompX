package com.compx;

import org.springframework.beans.factory.annotation.Autowired;

public class IntelProcessor implements Processor {

	// private field for the dependency
	private GameService gameService;
	private String name;
	private double freq;
	private IntelMotherboard motherboard;
	private Cache cache;

	public IntelProcessor() {

	}

	// constructor for dependency injection
	public IntelProcessor(GameService gameSer) {
		this.gameService = gameSer;
	}

	public IntelProcessor(String name) {
		this.name = name;
	}

	public IntelProcessor(double freq) {
		this.freq = freq;
	}

	public IntelProcessor(String name, double freq) {
		System.out.println("********* Intel values init by constructor *********");
		this.name = name;
		this.freq = freq;
	}

	@Override
	public String getProcessorName() {
		return "Intel i3 9100F";
	}

	@Override
	public String getSupportedMotherboard() {
		return gameService.getSupportedGames();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("********* Intel Name init by setter *********");
		this.name = name;
	}

	public double getFreq() {
		return freq;
	}

	public void setFreq(double freq) {
		System.out.println("********* Intel Frequency init by setter *********");
		this.freq = freq;
	}

	public IntelMotherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(IntelMotherboard motherboard) {
		this.motherboard = motherboard;
	}

	public Cache getCache() {
		return cache;
	}

	@Autowired
	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
