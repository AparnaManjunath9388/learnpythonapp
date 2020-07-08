package com.appium.bdd.learnpython.utils;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import io.appium.java_client.events.api.general.AlertEventListener;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

public class EventHandler implements AppiumWebDriverEventListener {

	EventLogger EventLogger;
	
	public EventHandler() {
		EventLogger = new EventLogger();
	}
	
	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		EventLogger.logEvent("value: " + arg0.getAttribute("value") + " has been set", StepStatus.PASS);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		EventLogger.logEvent("Before changing the value: " + arg0.getAttribute("value"), StepStatus.PASS);
	}

	/*@Override
	public void afterAlertAccept(WebDriver arg0, Alert arg1) {
		EventLogger.logEvent("Accepted the alert: " + arg1.getText(), StepStatus.PASS);
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0, Alert arg1) {
		EventLogger.logEvent("Accepted the alert: " + arg1.getText(), StepStatus.PASS);
	}

	@Override
	public void afterAlertSendKeys(WebDriver arg0, Alert arg1, String arg2) {
		EventLogger.logEvent("String entered in alert window: " + arg2, StepStatus.PASS);
	}*/

	/*@Override
	public void beforeAlertAccept(WebDriver arg0, Alert arg1) {
		EventLogger.logEvent("Before accepting Alert: " + arg1.getText(), StepStatus.PASS);
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0, Alert arg1) {
		EventLogger.logEvent("Before dismissing alert: " + arg1.getText(), StepStatus.PASS);
	}

	@Override
	public void beforeAlertSendKeys(WebDriver arg0, Alert arg1, String arg2) {
		EventLogger.logEvent("Before sending string: " + arg2, StepStatus.PASS);
	}
*/
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		EventLogger.logEvent("After accepting alert", StepStatus.PASS);
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		EventLogger.logEvent("After alter dismiss", StepStatus.PASS);
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		EventLogger.logEvent("Intended to set " + arg2[0] + ", actually set " + arg0.getAttribute("value"), StepStatus.PASS);
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		EventLogger.logEvent("Clicked on: " + arg0.toString(), StepStatus.PASS);
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		EventLogger.logEvent("Found element using " + arg0.toString(), StepStatus.PASS);
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		EventLogger.logEvent("Took screenshot: " + arg0.toString(), StepStatus.PASS);
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		EventLogger.logEvent("Text read: " + arg2, StepStatus.PASS);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		EventLogger.logEvent("After navigating backward: " + arg0.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		EventLogger.logEvent("After navigating forward: " + arg0.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		EventLogger.logEvent("After navigate refresh: " + arg0.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		EventLogger.logEvent("URL After navigating to " + arg0 + ": " + arg1.getCurrentUrl(), StepStatus.PASS);	
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		EventLogger.logEvent("URL After navigating to " + arg0 + ": " + arg1.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		EventLogger.logEvent("Window title after switching: " + arg1.getTitle(), StepStatus.PASS);
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		EventLogger.logEvent("Before clicking on element " + arg0.toString(), StepStatus.PASS);
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		EventLogger.logEvent("Before findBy: " + arg0.toString(), StepStatus.PASS);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		EventLogger.logEvent("Before getting screenshot: " + arg0.toString(), StepStatus.PASS);
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		EventLogger.logEvent("Before getting text from : " + arg0.toString(), StepStatus.PASS);
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		EventLogger.logEvent("URL Before navigating back: " + arg0.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		EventLogger.logEvent("URL Before navigating forward: " + arg0.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		EventLogger.logEvent("URL Before navigate Refresh: " + arg0.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		EventLogger.logEvent("URL Before navigating to " + arg0 + ": " + arg1.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		EventLogger.logEvent("Before running script: " + arg0, StepStatus.PASS);
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		EventLogger.logEvent("Before switching window: " + arg1.getCurrentUrl(), StepStatus.PASS);
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		EventLogger.logEvent("Cause: " + arg0.getCause() + ". Message: " + arg0.getMessage(), StepStatus.FAIL);
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		EventLogger.logEvent("Before accepting Alert", StepStatus.PASS);
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		EventLogger.logEvent("Before dismissing Alert", StepStatus.PASS);
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		EventLogger.logEvent("Before changing value of element: " + arg0.getAttribute("value"), StepStatus.PASS);
	}
	
	

}
