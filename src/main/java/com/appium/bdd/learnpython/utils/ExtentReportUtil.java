package com.appium.bdd.learnpython.utils;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportUtil {
	
	private static ExtentTest feature;
	private ExtentTest scenario;
	private static ExtentReports extent;
	private ConfigFileManager ConfigManager;
	private EventLogger EventLogger;
	private static String Reportpath;
	
	public ExtentReportUtil() throws Exception {
		ConfigManager = new ConfigFileManager();
		EventLogger = new EventLogger();
	}
	
	public void createReport() throws Exception {
		try {
			
			ExtentHtmlReporter htmlReporter;
			String AppName = ConfigManager.getAppName();
			String TestRunID = AppName + "_" + LocalDateTime.now().toString().replace(":", "_").replace(".", "_");
			String path = ConfigManager.getHtmlReportPath() + File.separator  + "ExecutionReport_" + TestRunID + ".html";
			Reportpath = path;
			
			htmlReporter = new ExtentHtmlReporter(path);
			ExtentBDDReporter bddReporter = new ExtentBDDReporter(path);
			extent = new ExtentReports();  //create object of ExtentReports
			extent.attachReporter(htmlReporter);
			extent.attachReporter(bddReporter);
	
			htmlReporter.config().setDocumentTitle(AppName + ": Automation Execution Report"); // Title of Report
			htmlReporter.config().setReportName(AppName + ": Automation Execution Report"); // Name of the report
			htmlReporter.config().setTheme(Theme.STANDARD);//Default Theme of Report
	
			// General information related to application
			extent.setSystemInfo("Application Name", AppName);
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Envirnoment", "SIT");
			
			EventLogger.logEvent("Created HTML Report in path: " + path, StepStatus.PASS);
			
		} catch(Exception e) {
			throw new Exception("Exception while creating HtmlReport: " + e.getMessage());
		}
	}
	
	public void flushReport() {
		extent.flush();
		EventLogger.logEvent("Flushed HTML report", StepStatus.PASS);
	}
	
	public void addScenarioStepDetails(WebDriver driver, GherkinKeyword keyword, String stepName, String Actual, StepStatus status) throws Exception {
		
		ExtentTest step = scenario.createNode(keyword, stepName, "");
		EventLogger.logEvent("Created Node in HTML Report: " + stepName, StepStatus.PASS);
		
		if(status == StepStatus.FAIL)
		{
			
			step.log(Status.FAIL, MarkupHelper.createLabel(Actual, ExtentColor.RED));
			String screenshotPath = takeScreeshot(driver);
			//To add it in the extent report 

			step.fail("Snapshot " + step.addScreenCaptureFromPath(screenshotPath));
			
		} else if(status == StepStatus.WARNING)
			step.log(Status.PASS, MarkupHelper.createLabel(Actual, ExtentColor.GREEN));
			

		else if(status == StepStatus.PASS)
		{
			step.log(Status.PASS, MarkupHelper.createLabel(Actual, ExtentColor.GREEN));
		}
		EventLogger.logEvent("Reported step details to HTML Report: " + stepName + " - " + Actual, StepStatus.PASS);
	}
	
	public String takeScreeshot(WebDriver driver) throws Exception {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils FileUtil = FileUtils.getFileUtils();
			String FileName = System.currentTimeMillis() + ".png";
			FileUtil.copyFile(srcFile, new File(FileName));
			return FileName;
		} catch(Exception e) {
			throw new Exception("Exception while taking screenshot: " + e.getMessage());
		}
		
	}
	
	public void addScenarioNode(String scenarioName) {
		scenario = feature.createNode(scenarioName);
		EventLogger.logEvent("Created Node in HTML Report: " + scenarioName, StepStatus.PASS);
	}
	
	public void addFeatureNode(String featureName) {
		feature = extent.createTest(featureName);
		EventLogger.logEvent("Created Node in HTML Report: " + featureName, StepStatus.PASS);
	}
	
	public void skipTest(String scenarioName) {
		feature.createNode(scenarioName).skip("Skipped");
		EventLogger.logEvent("Created Skipped-Test Node in HTML Report: " + scenarioName, StepStatus.PASS);
	}
	
	public String getReportPath() {
		return Reportpath;
	}
}
