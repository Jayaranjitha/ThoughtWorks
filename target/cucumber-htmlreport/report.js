$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTest.feature");
formatter.feature({
  "line": 2,
  "name": "Login Test for Docomo 20B-038 Release",
  "description": "",
  "id": "login-test-for-docomo-20b-038-release",
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
  "id": "login-test-for-docomo-20b-038-release;my-site-login-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is already on Login Page",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.open_the_Firefox_and_launch_the_application()"
});
formatter.result({
  "duration": 26574705900,
  "status": "passed"
});
});