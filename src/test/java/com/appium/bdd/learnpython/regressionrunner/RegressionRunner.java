package com.appium.bdd.learnpython.regressionrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.bdd.learnpython.utils.ExtentReportUtil;
import com.appium.bdd.learnpython.utils.SendEmail;
import com.appium.bdd.learnpython.utils.EventLogger;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(
        features = "C:\\Users\\aparn\\eclipse-workspace\\learnpythonapp\\src\\main\\java\\com\\appium\\bdd\\learnpython\\features",
        monochrome = true,
        glue = {"com.appium.bdd.learnpython.stepdefinitions"},
        tags = {"@RegressionTest", "~@Ignore"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class RegressionRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    private ExtentReportUtil ReportingUtil;
    private EventLogger EventLogger;
    
    @BeforeSuite
    public void BeforeTheSuite() {
    	EventLogger = new EventLogger();
    	EventLogger.initializeLogFile();
    }
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        
        ReportingUtil = new ExtentReportUtil();
		ReportingUtil.createReport();
		
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
    	ReportingUtil.addFeatureNode(cucumberFeature.getCucumberFeature().getGherkinFeature().getName());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    
    @AfterSuite
    public void AfterTheSuite() throws Exception {
    	SendEmail SendEmail = new SendEmail();
    	SendEmail.sendMail(ReportingUtil.getReportPath());
    }
}
