package com.compx.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public String getL2Cache())")
	public void loggingAdvice() {
		System.out.println("Advice run before get method called");
	}

	@Before("execution(public String com.compx.Cache.getL3Cache())")
	public void loggingAdviceForL3() {
		System.out.println("Advice run before specific L3 cache get method called");
	}
	
	@Before("execution(public String com.compx.Cache.get*())")
	public void loggingAdviceGetAllStringTypes() {
		System.out.println("Advice run before for all Cache getter method calls(String return type)");
	}
	
	@After("afterAllGetters()")
	public void loggingAdviceForL3AfterCall() {
		System.out.println("Advice run after all cache get method called using pointcut");
	}
	// Using pointcut for same expression to be applied over different execution methods
	@Pointcut("execution(public String com.compx.Cache.get*())")
	public void afterAllGetters() { }
	
}
