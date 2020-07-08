package com.appium.bdd.learnpython.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import com.appium.bdd.learnpython.utils.CommonMethods;
import com.appium.bdd.learnpython.utils.MobileElementsManager;

public class BaseActivity {
	
	protected AppiumDriver<MobileElement> driver;
	protected CommonMethods CommonMethods;
	protected MobileElementsManager ElementsManager;
	
	public BaseActivity(AppiumDriver<MobileElement> driver) throws Exception {
		this.driver = driver;
		CommonMethods = new CommonMethods();
		ElementsManager = new MobileElementsManager(driver);
	}

}
