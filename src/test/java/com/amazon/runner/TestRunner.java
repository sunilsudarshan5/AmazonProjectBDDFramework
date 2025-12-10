package com.amazon.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.amazon.stepdefinitions","com.amazon.hooks"},
    plugin = {"pretty","html:target/cucumber-reports/cucumber.html"},
    monochrome = true,
    tags = "@UI",
    dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
