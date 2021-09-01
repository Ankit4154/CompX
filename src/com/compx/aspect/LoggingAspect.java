package com.compx.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public String getL2Cache())")
	public void LoggingAdvice() {
		System.out.println("Advice run, get method called");
	}

}
