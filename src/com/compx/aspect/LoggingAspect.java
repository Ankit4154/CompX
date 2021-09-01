package com.compx.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public String getL2Cache())")
	public void loggingAdvice() {
		System.out.println("Advice run, get method called");
	}

	@Before("execution(public String com.compx.Cache.getL3Cache())")
	public void loggingAdviceForL3() {
		System.out.println("Advice run, specific L3 cache get method called");
	}
	
	@Before("execution(public String com.compx.Cache.get*())")
	public void loggingAdviceGetAllStringTypes() {
		System.out.println("Advice run, for all Cache getter method calls(String return type)");
	}
	
}
