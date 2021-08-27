package com.compx;

import org.springframework.stereotype.Component;

@Component
public class GameService implements Game {

	@Override
	public String getSupportedGames() {
		return "\n***** List of supported games *****" + "\nRise of the Tomb Raider" + "\nCounter Strike Go"
				+ "\nOverwatch";
	}

}
