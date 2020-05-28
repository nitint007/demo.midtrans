/**
 * 
 */
package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*
 * PLZ read "https://docs.cucumber.io/cucumber/api/#running-cucumber" for more
 * details on cucumber options
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-reports"},
features = "src/test/resources/features", 
tags = {"@purchase"},
glue = "stepDefinitions",
monochrome = true,
strict = false)


/**
 * @author nitinthite
 *
 */
/*
 * The first point which triggers the automation suite selected
 */
public class TestRunner {

}
