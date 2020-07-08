package com.appium.bdd.learnpython.utils;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;

public class AppiumDriverManager {
	
	public static AppiumDriver<MobileElement> driver = null;
	private ConfigFileManager ConfigManager;
	
	public AppiumDriverManager() throws Exception {
		try {
			ConfigManager = new ConfigFileManager();
		} catch(Exception e) {
			throw e;
		}
	}
	
	public void initializeDriver() throws Exception {
		
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", ConfigManager.getDeviceName());
			cap.setCapability("udid", ConfigManager.getUdid());
			cap.setCapability("platformName", ConfigManager.getPlatformName());
			cap.setCapability("platformVersion", ConfigManager.getPlatformVersion());
			
			//get this from apk info app in your mobile
			cap.setCapability("appPackage", ConfigManager.getAppPackage());
			cap.setCapability("appActivity", ConfigManager.getAppActivity());
			
			URL url = new URL(ConfigManager.getURL());
			driver = new AppiumDriver<MobileElement>(url, cap);
			
			AppiumDriver<MobileElement> mydriver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new EventHandler());
			driver = mydriver;
			driver.switchTo().alert().dismiss();
			
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		} catch(Exception e) {
			throw new Exception("Exception from AppiumDriverManager.initializeDriver: " + e.getMessage());
		}
	}
	
	public void tearDownDriver() {
		driver.quit();
	}
	
	public AppiumDriver<MobileElement> getDriver(){
		return driver;
	}

}
