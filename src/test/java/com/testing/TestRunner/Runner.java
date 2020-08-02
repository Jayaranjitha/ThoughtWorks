package com.testing.TestRunner;		

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/Features"}, glue= {"com.test.java.stepDefinitions"}, tags="@ThoughtWorks", 
plugin = { "pretty", "html:target/htmlreports", "json:target/htmlreports/cucumber.json"})

public class Runner 				
{		

}