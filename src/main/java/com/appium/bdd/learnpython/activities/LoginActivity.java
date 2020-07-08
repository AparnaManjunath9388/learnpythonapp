package com.appium.bdd.learnpython.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginActivity extends BaseActivity {

	public LoginActivity(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	public boolean assertLoginPageLayout() throws Exception {
		try {
			return ElementsManager.getElement("login.InputLayout").isDisplayed();
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.assertLoginPageLayout: " + e.getCause() + " - " + e.getMessage());
		}
		
	}
	
	public HomeActivity loginToApp(String username, String password) throws Exception {
		
		try {
			driver.context("NATIVE_APP");
			ElementsManager.getElement("login.emailid").sendKeys(username);
			Thread.sleep(1000);
			ElementsManager.getElement("login.password").sendKeys(password);
			Thread.sleep(1000);
			ElementsManager.getElement("login.signInBtn").click();
			Thread.sleep(1000);
			return new HomeActivity(driver);
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.loginToApp: " + e.getCause() + " - " + e.getMessage()); 
		}
	}
	
	public boolean logoAssertion() throws Exception {
		try {
			return ElementsManager.getElement("login.logo").isDisplayed();
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.logoAssertion: " + e.getCause() + " - " + e.getMessage());
		}
		
	}
	
	public boolean clickOnForgotPwd() throws Exception {
		try {
			ElementsManager.getElement("login.forgotPasswordLink").click();
			return true;			
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.clickOnForgotPwd: " + e.getCause() + " - " + e.getMessage());
		}

	}
	
	public boolean sendEmailToResetPwd(String emailId) throws Exception {
		
		try {
			driver.switchTo().alert();
			ElementsManager.getElement("login.resetPwdEmailTxtBx").sendKeys(emailId);
			Thread.sleep(1000);
			ElementsManager.getElement("login.SendEmailBtn").click();
			return true;
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.sendEmailToResetPwd: " + e.getCause() + " - " + e.getMessage());
		}
	}
	
	public boolean verifyEmailSentPopup(String expectedContent) throws Exception {
		
		try {
			driver.switchTo().alert();
			boolean contentAssert = ElementsManager.getElement("login.emailSentAlertText").getText().contains(expectedContent);
			ElementsManager.getElement("login.emailSentOkBtn").click();
			return contentAssert;
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.verifyEmailSentPopup: " + e.getCause() + " - " + e.getMessage());
		}
	}
	
	public boolean clickOnCreateNewAccount() throws Exception {
		try {
			ElementsManager.getElement("login.createNewAccountLink").click();
			return true;			
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.clickOnCreateNewAccount: " + e.getCause() + " - " + e.getMessage());
		}

	}
	
	public HomeActivity enterNewAccountDetails(String EmailId, String Name, String Password) throws Exception {
		
		try {
			ElementsManager.getElement("login.NewAccountEmailId").sendKeys(EmailId);
			Thread.sleep(1000);
			ElementsManager.getElement("login.NewAccountName").sendKeys(Name);
			Thread.sleep(1000);
			ElementsManager.getElement("login.NewAccountPassword").sendKeys(Password);
			Thread.sleep(1000);
			ElementsManager.getElement("login.NewAccountSignUpBtn").click();
			return new HomeActivity(driver);			
		} catch(Exception e) {
			throw new Exception("Exception from method LoginActivity.enterNewAccountDetails: " + e.getCause() + " - " + e.getMessage());
		}

	}
	
	
}
