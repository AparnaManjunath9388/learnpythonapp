package com.appium.bdd.learnpython.regressionrunner;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class working {

	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) {
		try {
			System.out.println("starting App");
			
			openApp();
			/*System.out.println("opened calculator");
			clearTheCurrentCalculation();
			System.out.println("Addition of 4 and 5: " + OperateOnSingleDigits(4, 5, "plus"));
			clearTheCurrentCalculation();
			System.out.println("Minus of 8 and 5: " + OperateOnSingleDigits(8, 5, "minus"));
			clearTheCurrentCalculation();
			System.out.println("Multiplication of 9 and 5: " + OperateOnSingleDigits(9, 5, "multiply"));
			clearTheCurrentCalculation();
			System.out.println("Division of 8 and 4: " + OperateOnSingleDigits(8, 4, "divide"));
			clearTheCurrentCalculation(); */
			
		} catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void openApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Honor 9N");
		cap.setCapability("udid", "CYG3Y18719020630");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
		//get this from apk info app in your mobile
		//cap.setCapability("appPackage", "com.android.calculator2");
		//cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		cap.setCapability("appPackage", "com.sololearn.python");
		cap.setCapability("appActivity", "com.sololearn.app.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		System.out.println(driver.getContextHandles());
		driver.findElement(By.id("com.sololearn.python:id/input_email")).sendKeys("aparna12.rao@gmail.com");
		
		System.out.println("App started...");
				
	}
	
	public static void clearTheCurrentCalculation() {
		driver.findElement(By.id("com.android.calculator2:id/op_clr")).click();
	}
	
	public static String OperateOnSingleDigits(int a, int b, String operation) {
		
		String baseId = "com.android.calculator2:id/";
		
		String buttonId;
		
		String[] buttonsToClick = {Integer.toString(a), operation, Integer.toString(b), "equals"};
		try {
			for(String digit : buttonsToClick) {
				switch(digit) {
				case "0":
					buttonId = "digit_0";
					break;
				case "1":
					buttonId = "digit_1";
					break;
				case "2":
					buttonId = "digit_2";
					break;
				case "3":
					buttonId = "digit_3";
					break;
				case "4":
					buttonId = "digit_4";
					break;
				case "5":
					buttonId = "digit_5";
					break;
				case "6":
					buttonId = "digit_6";
					break;
				case "7":
					buttonId = "digit_7";
					break;
				case "8":
					buttonId = "digit_8";
					break;
				case "9":
					buttonId = "digit_9";
					break;
				case "plus":
					buttonId = "op_add";
					break;
				case "minus":
					buttonId = "op_sub";
					break;
				case "multiply":
					buttonId = "op_mul";
					break;
				case "divide":
					buttonId = "op_div";
					break;
				default:
					buttonId = "eq";
					break;
				}
				
				driver.findElement(By.id(baseId + buttonId)).click();
				Thread.sleep(500);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return driver.findElement(By.id(baseId + "formula")).getText();
		
	}

}

