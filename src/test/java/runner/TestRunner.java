/**
 * The starting or trigerring point for the project
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
@CucumberOptions(plugin = { "pretty", "html:target/html/",
"html:target/setup-reports"},
features = "src/test/resources/features", 
tags = {"@Purchase"},
glue = "stepDefinitions",
monochrome = true,
strict = false)


/**
 * @author nitinthite
 * The first point which triggers the automation suite selected
 */
public class TestRunner {

}
