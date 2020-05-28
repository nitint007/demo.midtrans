/**
 * 
 */
package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nitinthite
 *
 */
public class Purchase {
	
	@Given("^user adds pillow to the cart$")
	public void user_adds_pillow_to_the_cart() throws Throwable {
	   System.out.println("I am in step Defs");
	}

	@When("^entered valid details$")
	public void entered_valid_details() throws Throwable {
	    
	}

	@Then("^purchase should be successful$")
	public void purchase_should_be_successful() throws Throwable {
	    
	}

	@When("^entered invalid details \"([^\"]*)\"$")
	public void entered_invalid_details(String arg1) throws Throwable {
	   
	}

	@Then("^purchase should be un-successful$")
	public void purchase_should_be_un_successful() throws Throwable {
	   
	}

}
