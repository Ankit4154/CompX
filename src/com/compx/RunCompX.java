package com.compx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunCompX {

	public static void main(String[] args) {

		// load spring configuration file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * Objects of all the defined beans in applicationContext.xml gets initialized
		 * irrespective of the fact whether they are called further in this class or
		 * not.
		 */
		// retrieve bean from spring container
		Processor proc = context.getBean("selectedProcessor", Processor.class);
		// call methods on bean
		System.out.println(proc.getProcessorName());
		// testing constructor injection
		System.out.println(proc.getSupportedMotherboard());

		// retrieve RyzenProcessor bean
		RyzenProcessor ryzenProc = context.getBean("ryzenProc", RyzenProcessor.class);
		// testing setter injection
		System.out.println(ryzenProc.getProcessorName());
		System.out.println(ryzenProc.getSupportedMotherboard());
		System.out.println("********* Calling getter for ryzen *********");
		// calling getter with initialized value from xml
		System.out.println("Name : "+ryzenProc.getName());
		System.out.println("L2 Cache : "+ryzenProc.getCache().getL2Cache());

		// retrieve IntelProcessor bean
		// Either cast the context.getBean as below or provide the class name as 2nd
		// parameter as above
		IntelProcessor intelProc = (IntelProcessor) context.getBean("intelProc");
		System.out.println("********* Calling getter for intel *********");
		// calling getter with initialized value from properties file
		System.out.println("Name : "+intelProc.getName());
		System.out.println("Frequency : "+intelProc.getFreq());
		System.out.println("Socket type : "+intelProc.getMotherboard().getSocketType());
		System.out.println("L2 Cache : "+intelProc.getCache().getL2Cache());
		System.out.println("List of companies : ");
		for(String x : intelProc.getMotherboard().getCompanies())
			System.out.println(x);
		
		// for automatic/graceful application context closure when JVM ends
		((AbstractApplicationContext) context).registerShutdownHook();
		// close context
		// context.close();
	}

}
