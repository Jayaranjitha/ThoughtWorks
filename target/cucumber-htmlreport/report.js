$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTest.feature");
formatter.feature({
  "line": 2,
  "name": "My site Login Test",
  "description": "",
  "id": "my-site-login-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ThoughtWorksChk"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "My Site Login Details",
  "description": "",
  "id": "my-site-login-test;my-site-login-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is already on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters user name and password",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user clicks on \"login\" button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user verifies the Page Title",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.open_the_Firefox_and_launch_the_application()"
});
formatter.result({
  "duration": 40014929200,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_enters_username_and_password()"
});
