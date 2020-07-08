#Author: aparna.manjunath@wellsfargo.com

Feature: Login Activity scenarios

  @RegressionTest
  Scenario: Assert Login Page logo image
    Given App is already open and user is on Login Page
    Then Learn Python logo should be on top of E-mail and Password fields
    
  @RegressionTest
  Scenario: Login to Learn Python App
    Given App is already open and user is on Login Page
    When User enters email and password in Email and Password fields respectively and hits on Login button
    Then User should land up in Home page

	@Ignore
	Scenario: Reset Password
		Given App is already open and user is on Login Page
		When User clicks on Forgot Password link a popup with title Reset Password should appear with an empty field in which user enters valid-registered Email-id and click on SEND EMAIL
		Then A pop up appears with title Email Sent with expected content and user clicks on ok button
		Then Login page will come on foreground
		
	@Ignore
	Scenario: Create new account
		Given App is already open and user is on Login Page
		When User clicks on CREATE NEW ACCOUNT link and enters E-mail Name and Password fields and its SIGN UP button
		Then User should land up in Home page
		
		