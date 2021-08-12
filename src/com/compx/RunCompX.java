package com.compx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunCompX {

	public static void main(String[] args) {

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		Processor proc = context.getBean("ryzenProc", Processor.class);
		// call methods on bean
		System.out.println(proc.getProcessorName());
		// close context
		context.close();
	}

}
