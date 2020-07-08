package com.appium.bdd.learnpython.activities;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeActivity extends BaseActivity {

	public HomeActivity(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	public boolean assertHomeScreen() throws Exception {
		try {
			return (!ElementsManager.findElementsByAccessibility("home.learnoption").isEmpty());
		} catch(Exception e) {
			throw new Exception("Exception from method HomeActivity.assertHomeScreen" + e.getCause() + " - " + e.getMessage());
		}
			
	}
	
	public boolean selectTab(String TabObjName) throws Exception {
		
		boolean result = false;
		try {
			List<MobileElement> tabs = ElementsManager.findElementsByAccessibility(TabObjName);
			
			if (!tabs.isEmpty()) {
				tabs.get(0).click();
				result = true;
			} else {
				result = false;
			}
			return result;
		} catch(Exception e) {
			throw new Exception("Exception from method HomeActivity.selectTab: " + e.getCause() + " - " + e.getMessage());
		}
	}
	
	public String verifyPresenceOfComponents(String ListOfComponents) throws Exception {
		
		try {
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> presentComp = new ArrayList<String>();
		    String[] components = ListOfComponents.split(",");
		    
		    for (String comp : components)
		    	list.add(comp);
			
			String listOfMissingComponents = "";
	
			List<MobileElement> allComponents = ElementsManager.findElements("home.componentNames");
			
			if (!allComponents.isEmpty()) {
				for (MobileElement component : allComponents) {
					String text = component.getText();
					presentComp.add(text);
				}
				
				for (String comp : list) {
					if (!presentComp.contains(comp))
						listOfMissingComponents += comp + ",";
				}
			} else {
				listOfMissingComponents = ListOfComponents;
			}
			return listOfMissingComponents;
		} catch(Exception e) {
			throw new Exception("Exception from method HomeActivity.verifyPresenceOfComponents: " + e.getCause() + " - " + e.getMessage());
		}
		
	}
	
	public boolean logOut() throws Exception {
		try {
			ElementsManager.getElement("home.menu").click();
			ElementsManager.getElement("home.logout").click();
			return true;			
		} catch(Exception e) {
			throw new Exception("Exception from method HomeActivity.logOut: " + e.getCause() + " - " + e.getMessage());
		}

	}

}
