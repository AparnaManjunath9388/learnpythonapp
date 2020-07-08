package com.appium.bdd.learnpython.stepdefinitions;

import com.appium.bdd.learnpython.utils.AppiumDriverManager;
import com.appium.bdd.learnpython.utils.ExtentReportUtil;
import com.appium.bdd.learnpython.utils.StepStatus;
import com.aventstack.extentreports.GherkinKeyword;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.appium.bdd.learnpython.activities.LoginActivity;

import java.util.Hashtable;

import com.appium.bdd.learnpython.activities.HomeActivity;

public class HomeActivityStepDef {
	
	private AppiumDriver<MobileElement> driver;
	private ExtentReportUtil ReportingUtil;
	private Hashtable<String, String> TestParams = null;
	private String StepName, Actual;
	private StepStatus status;
	private GherkinKeyword keyword;
	
	private HomeActivity HomeActivity;
	
	public HomeActivityStepDef() {
		driver = AppiumDriverManager.driver;
		ReportingUtil = Hooks.ReportingUtil;
		
		if (!Hooks.TestParams.isEmpty()) {
			TestParams = new Hashtable<String, String>();
			TestParams.putAll(Hooks.TestParams);
		}
	}
	
	@Given("^User has already logged in and is on Home screen$")
	public void user_has_already_logged_in_and_is_on_Home_screen() throws Exception {

		StepName = "User has already logged in and is on Home screen";
		status = StepStatus.FAIL;
		keyword = new GherkinKeyword("Given");
		try {
			LoginActivity LoginActivity = new LoginActivity(driver);
			HomeActivity = LoginActivity.loginToApp(TestParams.get("EmailId"), TestParams.get("Password"));
			Actual = "Logged in to app successfully";
			status = StepStatus.PASS;			
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}
	
	@Then("^Under LEARN tab all the expected components should be present$")
	public void User_learn_tab_all_expected_components_should_be_present() throws Exception {
		
		StepName = "Under '" + "LEARN" + "' tab all the expected components should be present";
		status = StepStatus.FAIL;
		keyword = new GherkinKeyword("Then");
		
		try {
			if (HomeActivity.selectTab("home.learnoption")) {
				String missingComponents = HomeActivity.verifyPresenceOfComponents(TestParams.get("HomeScreenComponents"));
				if (missingComponents == "") {
					Actual = "All expected components are present in LEARN tab";
					status = StepStatus.PASS;
				} else {
					Actual = "Missing components: " + missingComponents;
				}
			} else {
				Actual = "Failed to select '" + "LEARN" + "' tab";
			}
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
			HomeActivity.logOut();
		}
	}
}
