package com.compx;

import com.compx.aspect.LoggingAspect;

public class RyzenProxy extends RyzenProcessor {
	
	public String getName() {
		new LoggingAspect().beforeAdvice();
		return super.getName();
	}
	
}
