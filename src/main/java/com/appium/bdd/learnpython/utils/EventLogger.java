package com.appium.bdd.learnpython.utils;

import org.apache.log4j.Logger;

public class EventLogger {
	
	private static Logger log;
	
	public void initializeLogFile() {
		log = Logger.getLogger(EventLogger.class);
	}
	
	public void logEvent(String message, StepStatus status) {
		
		if (status == StepStatus.FAIL) {
			log.error(message);
		} else {
			log.info(message);
		}
	}
	

}
