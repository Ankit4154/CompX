package com.compx;

public class IntelMotherboard implements Motherboard {

	private String socketType;
	@Override
	public String getMotherBoard() {
		return "LGA 1151 Socket Motherboard";
	}
	
	public String getSocketType() {
		return socketType;
	}
	public void setSocketType(String socketType) {
		this.socketType = socketType;
	}

}
