package com.appium.bdd.learnpython.stepdefinitions;

import com.appium.bdd.learnpython.utils.AppiumDriverManager;
import com.appium.bdd.learnpython.utils.ExtentReportUtil;
import com.appium.bdd.learnpython.utils.StepStatus;
import com.aventstack.extentreports.GherkinKeyword;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Hashtable;
import com.appium.bdd.learnpython.activities.LoginActivity;
import com.appium.bdd.learnpython.activities.HomeActivity;
public class LoginActivityStepDef {

	private AppiumDriver<MobileElement> driver;
	private ExtentReportUtil ReportingUtil;
	private Hashtable<String, String> TestParams;
	private String StepName, Actual;
	private StepStatus status;
	private GherkinKeyword keyword;
	
	
	private LoginActivity LoginActivity;
	private HomeActivity HomeActivity;
	
	public LoginActivityStepDef() throws Exception {
		driver = AppiumDriverManager.driver;
		ReportingUtil = Hooks.ReportingUtil;
		if (!Hooks.TestParams.isEmpty()) {
			TestParams = new Hashtable<String, String>();
			TestParams.putAll(Hooks.TestParams);
		}
		
		LoginActivity = new LoginActivity(driver);
	}
	
	@Given("^App is already open and user is on Login Page$")
	public void App_is_already_open_and_user_is_on_Login_Page() throws Exception {
		
		StepName = "App is open and User is on Login Page";
		keyword = new GherkinKeyword("When");
		status = StepStatus.FAIL;
		try {
			if (LoginActivity.assertLoginPageLayout()) {
				Actual = "Login Layout is present";
				status = StepStatus.PASS;
			} else {
				Actual = "Login layout is not present";
			}			
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}	
	}
	
	@Then("^Learn Python logo should be on top of E-mail and Password fields$")
	public void Learn_Python_logo_sould_be_on_top() throws Exception {
		StepName = "Learn Python logo should appear on top of Email field";
		keyword = new GherkinKeyword("Then");
		status = StepStatus.FAIL;
		try {
			if (LoginActivity.logoAssertion()) {
				Actual = "Learn Python Logo is present as expected";
				status = StepStatus.PASS;
			} else {
				Actual = "Learn Python logo is not present";
			}
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}
	
	@When("^User enters email and password in Email and Password fields respectively and hits on Login button$")
	public void User_enters_emailid_password_and_clicks_on_login() throws Exception {
		StepName = "Learn Python logo should appear on top of Email field";
		keyword = new GherkinKeyword("When");
		status = StepStatus.FAIL;
		try {
			HomeActivity = LoginActivity.loginToApp(TestParams.get("EmailId"), TestParams.get("Password"));
			status = StepStatus.PASS;
			Actual = "Logged in to application without any errors";			
			
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}
	
	@Then("^User should land up in Home page$")
	public void User_should_land_up_in_Home() throws Exception {
		StepName = "User should land up in Home screen";
		keyword = new GherkinKeyword("Then");
		status = StepStatus.FAIL;
		try {
			if (HomeActivity.assertHomeScreen()) {
				Actual = "App is on Home screen";
				status = StepStatus.PASS;
			} else {
				Actual = "App is not on Home screen";
			}			
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
			HomeActivity.logOut();
		}
	}
	
	@When("^User clicks on Forgot Password link a popup with title Reset Password should appear with an empty field in which user enters valid-registered Email-id and click on SEND EMAIL$")
	public void reset_password() throws Exception {
		StepName = "User clicks on Forgot Password link and enters Username in the popup with title Reset Password";
		keyword = new GherkinKeyword("When");
		status = StepStatus.FAIL;
		
		try {
			if (LoginActivity.clickOnForgotPwd()) {
				if (LoginActivity.sendEmailToResetPwd(TestParams.get("EmailId"))) {
					Actual = "Password reset email sent successfully";
					status = StepStatus.PASS;
				} else {
					Actual = "Password reset email not sent";
				}
			} else {
				Actual = "Failed to click on Reset Password link";
			}			
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}
	
	@Then("^A pop up appears with title Email Sent with expected content and user clicks on ok button$")
	public void popup_appears_with_expected_content_and_user_clicks_on_ok_button() throws Exception {
		StepName = "A pop up appears with title '" + "Email Sent" + "' with expected content and user clicks on ok button";
		keyword = new GherkinKeyword("Then");
		status = StepStatus.FAIL;
		
		if (LoginActivity.verifyEmailSentPopup(TestParams.get("EmailSentPopup"))) {
			Actual = "Popup content as expected";
			status = StepStatus.PASS;
		} else {
			Actual = "Pop up content not as expected";
		}
		ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);	
	}
	
	@Then("^Login page will come on foreground$")
	public void login_page_will_come_on_foreground() throws Exception {
		StepName = "Login Page will come on foreground";
		keyword = new GherkinKeyword("Then");
		status = StepStatus.FAIL;
		
		try {
			if (LoginActivity.assertLoginPageLayout()) {
				Actual = "Login Layout is present";
				status = StepStatus.PASS;
			} else {
				Actual = "Login layout is not present";
			}			
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}
	
	@When("^User clicks on CREATE NEW ACCOUNT link and enters E-mail Name and Password fields and its SIGN UP button$")
	public void User_clicks_on_Createnewaccount_and_enters_fields() throws Exception {
		StepName = "Login Page will come on foreground";
		keyword = new GherkinKeyword("Then");
		status = StepStatus.FAIL;
		 try {
			String EmailId = TestParams.get("NewAccountEmail");
			String Name = TestParams.get("NewAccountName");
			String password = TestParams.get("NewAccountPwd");
			
			if (LoginActivity.clickOnCreateNewAccount()) {
				HomeActivity = LoginActivity.enterNewAccountDetails(EmailId, Name, password);
				Actual = "New account creation successful";
				status = StepStatus.PASS;
			} else {
				Actual = "Failed to click on '" + "CREATE NEW ACCOUNT" + "' link";
			}		 
		 } catch(Exception e) {
			 Actual = "Exception occured: " + e.getMessage();
		 } finally {
			 ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		 }
	}
}
