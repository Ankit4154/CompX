package com.compx;

public class GameService implements Game {

	@Override
	public String getSupportedGames() {
		return "***** List of supported games *****"
				+ "\nRise of the Tomb Raider"
				+ "\nCounter Strike Go"
				+ "\nOverwatch";
	}

}
