package com.appium.bdd.learnpython.utils;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileElementsManager {
	
	private AppiumDriver<MobileElement> driver;
	private ORParser ORparser;
	
	public MobileElementsManager(AppiumDriver<MobileElement> driver) throws Exception {
		this.driver = driver;
		ORparser = new ORParser();
	}

	public MobileElement getElement(String ElementNameInOR) throws Exception {
		return driver.findElement(ORparser.getBy(ElementNameInOR));
	}
	

	public MobileElement getElement(String property, String Value) throws Exception {
		
		
		switch(property.toLowerCase()) {
		 
		case "name":
			return driver.findElement(By.name(Value));
			
		case "id":
			return driver.findElement(By.id(Value));
			
		case "linktext":
			return driver.findElement(By.linkText(Value));
			
		case "partiallinktext":
			return driver.findElement(By.partialLinkText(Value));
	
		case "tagname":
			return driver.findElement(By.tagName(Value));
			
		case "cssselector":
			return driver.findElement(By.cssSelector(Value));
		
		case "classname":
			return driver.findElement(By.cssSelector(Value));
			
		case "xpath":
			return driver.findElement(By.xpath(Value));
		default:
			throw new Exception("Exception from ORParser.getBy: Unknown locator type '" + property + "'");

		}
		
	}
	
	public List<MobileElement> findElementsByAccessibility(String ElementNameInOR){
		String prop = ORparser.getObjectProperty(ElementNameInOR);
		String using = prop.split(";")[1];
		return driver.findElementsByAccessibilityId(using);
	}
	
	public List<MobileElement> findElements(String ElementNameInOR) throws Exception {
		return driver.findElements(ORparser.getBy(ElementNameInOR));
	}
	

}
