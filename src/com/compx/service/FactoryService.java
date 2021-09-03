package com.compx.service;

import com.compx.IntelProcessor;
import com.compx.RyzenProcessor;
import com.compx.RyzenProxy;

public class FactoryService {
	
	public Object getBean(String beanName) {
		
		switch(beanName) {
			case "IntelProcessor" :
				return new IntelProcessor();
			case "RyzenProcessor" :
				return new RyzenProxy();		
		}
		
		return null;
	}

}
