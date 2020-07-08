package com.appium.bdd.learnpython.stepdefinitions;

import java.util.Hashtable;

import com.appium.bdd.learnpython.utils.AppiumDriverManager;
import com.appium.bdd.learnpython.utils.ExcelDataProvider;
import com.appium.bdd.learnpython.utils.ExtentReportUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static ExtentReportUtil ReportingUtil;
	private AppiumDriverManager DriverManager;
	public static Hashtable<String, String> TestParams = null;
	
	public Hooks() throws Exception {
		ReportingUtil = new ExtentReportUtil();
	}
	@Before
	public void BeforeEachScenario(Scenario scenario) throws Exception {
		
		DriverManager = new AppiumDriverManager();
		DriverManager.initializeDriver();
		
		ReportingUtil.addScenarioNode(scenario.getName());
		
		ExcelDataProvider DataProvider = new ExcelDataProvider();
		TestParams = DataProvider.get("TestData", scenario.getName());
	}
	
	@After
	public void AfterEachScenario() throws Exception {
		
		DriverManager.tearDownDriver();
		
		ReportingUtil.flushReport();
		TestParams.clear();
	}

}
