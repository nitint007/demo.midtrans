/**
 * The entry point for the project execution
 */
package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*
 * PLZ read "https://docs.cucumber.io/setup/api/#running-setup" for more
 * details on setup options
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports"}, 
features = "src/test/resources/features", 
tags = { "@Purchase" }, // available tags @Purchase, @PositiveBuy, @NegativeBuy
glue = "stepDefinitions", 
monochrome = true, 
strict = false)

/**
 * @author nitinthite 
 * The first point which triggers the automation suite selected
 */
public class TestRunner {
	
	

}
