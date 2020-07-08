$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("001_LoginActivity.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: aparna.manjunath@wellsfargo.com"
    }
  ],
  "line": 3,
  "name": "Login Activity scenarios",
  "description": "",
  "id": "login-activity-scenarios",
  "keyword": "Feature"
});
formatter.before({
  "duration": 19022398400,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Assert Login Page logo image",
  "description": "",
  "id": "login-activity-scenarios;assert-login-page-logo-image",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "App is already open and user is on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Learn Python logo should be on top of E-mail and Password fields",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginActivityStepDef.App_is_already_open_and_user_is_on_Login_Page()"
});
formatter.result({
  "duration": 1401684400,
  "status": "passed"
});
formatter.match({
  "location": "LoginActivityStepDef.Learn_Python_logo_sould_be_on_top()"
});
formatter.result({
  "duration": 679212500,
  "status": "passed"
});
formatter.after({
  "duration": 1707731400,
  "status": "passed"
});
formatter.before({
  "duration": 12648458600,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Login to Learn Python App",
  "description": "",
  "id": "login-activity-scenarios;login-to-learn-python-app",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "App is already open and user is on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User enters email and password in Email and Password fields respectively and hits on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User should land up in Home page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginActivityStepDef.App_is_already_open_and_user_is_on_Login_Page()"
});
formatter.result({
  "duration": 1679364300,
  "status": "passed"
});
formatter.match({
  "location": "LoginActivityStepDef.User_enters_emailid_password_and_clicks_on_login()"
});
formatter.result({
  "duration": 1860661800,
  "status": "passed"
});
formatter.match({
  "location": "LoginActivityStepDef.User_should_land_up_in_Home()"
});
formatter.result({
  "duration": 1067565200,
  "error_message": "java.lang.NullPointerException\r\n\tat com.appium.bdd.learnpython.stepdefinitions.LoginActivityStepDef.User_should_land_up_in_Home(LoginActivityStepDef.java:115)\r\n\tat ✽.Then User should land up in Home page(001_LoginActivity.feature:14)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1096196800,
  "status": "passed"
});
formatter.uri("002_HomeActivity.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: aparna.manjunath@wellsfargo.com"
    }
  ],
  "line": 3,
  "name": "Home Activity scenarios",
  "description": "",
  "id": "home-activity-scenarios",
  "keyword": "Feature"
});
formatter.before({
  "duration": 12369297600,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Assert Home Page components",
  "description": "",
  "id": "home-activity-scenarios;assert-home-page-components",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User has already logged in and is on Home screen",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Under LEARN tab all the expected components should be present",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeActivityStepDef.user_has_already_logged_in_and_is_on_Home_screen()"
});
formatter.result({
  "duration": 2577265500,
  "status": "passed"
});
formatter.match({
  "location": "HomeActivityStepDef.User_learn_tab_all_expected_components_should_be_present()"
});
formatter.result({
  "duration": 1033692100,
  "error_message": "java.lang.NullPointerException\r\n\tat com.appium.bdd.learnpython.stepdefinitions.HomeActivityStepDef.User_learn_tab_all_expected_components_should_be_present(HomeActivityStepDef.java:83)\r\n\tat ✽.Then Under LEARN tab all the expected components should be present(002_HomeActivity.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1071159900,
  "status": "passed"
});
});