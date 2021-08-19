package com.compx;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class IntelMotherboard implements Motherboard, ApplicationContextAware, BeanNameAware {

	private String socketType;
	private List<String> companies;
	private ApplicationContext context;

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

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean Name : "+ name);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

}
