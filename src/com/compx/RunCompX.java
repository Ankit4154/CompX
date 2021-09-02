package com.compx;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.compx.service.FactoryService;

public class RunCompX {

	public static void main(String[] args) {

		// load spring configuration file
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * Objects of all the defined beans in applicationContext.xml gets initialized
		 * irrespective of the fact whether they are called further in this class or
		 * not.
		 */
		// retrieve bean from spring container
		Processor proc = context.getBean("selectedProcessor", Processor.class);

		System.out.println("********* Calling getter for selected processor bean *********");
		// call methods on bean
		System.out.println("Processor name : " + proc.getProcessorName());
		// testing constructor injection
		System.out.println(proc.getSupportedMotherboard());

		// retrieve RyzenProcessor bean
		RyzenProcessor ryzenProc = context.getBean("ryzenProc", RyzenProcessor.class);
		System.out.println("********* Calling getter for ryzen 1 *********");
		System.out.println(ryzenProc.getProcessorName());
		System.out.println(ryzenProc.getSupportedMotherboard());
		// calling getter with initialized value from xml
		System.out.println("Name : " + ryzenProc.getName());
		System.out.println("L2 Cache : " + ryzenProc.getCache().getL2Cache());
		System.out.println("Cache object : " + ryzenProc.getCache());

		// retrieve IntelProcessor bean
		// Either cast the context.getBean as below or provide the class name as 2nd
		// parameter as above
		IntelProcessor intelProc = (IntelProcessor) context.getBean("intelProc");
		System.out.println("********* Calling getter for intel 1 *********");
		// calling getter with initialized value from properties file
		System.out.println("Name : " + intelProc.getName());
		System.out.println("Frequency : " + intelProc.getFreq());
		System.out.println("Socket type : " + intelProc.getMotherboard().getSocketType());
		System.out.println("L2 Cache : " + intelProc.getCache().getL2Cache());
		System.out.println("Cache object : " + intelProc.getCache());
		System.out.println("List of companies : ");
		for (String x : intelProc.getMotherboard().getCompanies())
			System.out.println(x);

		intelProc = (IntelProcessor) context.getBean("intelProc2");
		System.out.println("********* Calling getter for intel 2 *********");
		System.out.println("Name : " + intelProc.getName());
		System.out.println("Frequency : " + intelProc.getFreq());
		System.out.println("L2 Cache : " + intelProc.getCache().getL2Cache());
		System.out.println("L3 Cache : " + intelProc.getCache().getL3Cache());
		intelProc.getCache().setL2Cache("Changed L2 Cache : 6MB");
		intelProc.getCache().setL3Cache("Changed L3 Cache : 10MB");
		System.out.println("Cache object : " + intelProc.getCache());
		System.out.println("********* Getting welcome message for working *********");
		System.out.println(context.getMessage("working", null, "Default working note", null));
		
		// Implementing own FactoryService to initialize and provide beans.
		FactoryService factoryService = new FactoryService();
		ryzenProc = (RyzenProcessor) factoryService.getBean("RyzenProcessor");
		ryzenProc.setName("Ryzen 3200g");
		System.out.println("Name : " + ryzenProc.getName());
		
		// for automatic/graceful application context closure when JVM ends
		context.registerShutdownHook();
		// close context
		// context.close();
	}

}
