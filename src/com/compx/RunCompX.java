package com.compx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunCompX {

	public static void main(String[] args) {

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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
		// for automatic/graceful application context closure when JVM ends
		context.registerShutdownHook();
		// close context
		//context.close();
	}

}
