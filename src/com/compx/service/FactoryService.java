package com.compx.service;

import com.compx.IntelProcessor;
import com.compx.RyzenProcessor;

public class FactoryService {
	
	public Object getBean(String beanName) {
		
		switch(beanName) {
			case "IntelProcessor" :
				return new IntelProcessor();
			case "RyzenProcessor" :
				return new RyzenProcessor();		
		}
		
		return null;
	}

}
