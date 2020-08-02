package com.testing.TestRunner;		

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/Features"}, glue= {"com.test.java.stepDefinitions"}, tags="@ThoughtWorksChk", plugin = {
        "pretty", "json:target/surefire-reports/cucumber.json"})
public class Runner 				
{		

}