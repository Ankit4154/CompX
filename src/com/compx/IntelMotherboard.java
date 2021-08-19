package com.compx;

import java.util.List;

public class IntelMotherboard implements Motherboard {

	private String socketType;
	private List<String> companies;

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

	public List<String> getCompanies() {
		return companies;
	}

	public void setCompanies(List<String> companies) {
		this.companies = companies;
	}

}
