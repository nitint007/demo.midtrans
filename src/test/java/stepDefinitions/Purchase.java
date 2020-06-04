/**
 * 
 */
package stepDefinitions;

import org.junit.AfterClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;

import pageobjects.BankDetails;
import pageobjects.CartPanel;
import pageobjects.CreditCardPayment;
import pageobjects.HomePage;
import pageobjects.OrderSummary;
import pageobjects.PaymentStatus;
import pageobjects.SelectPayment;
import setup.WebSetup;

/**
 * @author nitinthite
 *
 */
public class Purchase {
	
	//************** Cucumber Hooks @Before - to execute a suite precondition **************
	
	@Before
	public void beforeAllScenarios(Scenario s)  {
		System.out.println("Inside Hooks @Before");
		WebSetup.setUp();
	}
	
	//************** Junit Hook @After - to execute a common closure code **************
	
		@AfterClass
		public void closeDriverInstance() {
			
			// To close webdriver session
			WebSetup.driver.quit();
		}
	
	//************** @Given - implementation details **************
	
	// Method that is common and a pre-condition for scenarios
	@Given("^User adds pillow to the cart$")
	public void itemAddedToCart() throws Throwable {
		
		// Creating Page object for accessing respective methods
		HomePage homepage = new HomePage();
		
		// Steps for adding item to cart and verifying same
		homepage.clickBuyNowButton();
		
		CartPanel cartPanel = new CartPanel();
		cartPanel.clickCheckoutButton();
		
		OrderSummary ordersummary = new OrderSummary();
		ordersummary.clickContinue();
	}

	//************** @When - implementation details **************
	
	// Method for entering valid details for purchase
	@When("^Entered valid details$")
	public void enterValidDetails() throws Throwable {
		
		// Payment details for Credit card
	    SelectPayment selectpayment = new SelectPayment();
	    selectpayment.selectCreditCardOption();
	    
	    CreditCardPayment payment = new CreditCardPayment();
	    
	    //TODO - do not hardcode
	    payment.enterCardDetails("4811111111111114", "06/20", 123);
	    payment.isImportantMessageDisaplyed();
	    payment.clickPayNowButton();
	}
	
	// Method for entering invalid details for purchase
	@When("^Entered invalid details (\\d+)$")
	public void enterInvalidDetails(String cardNumber) throws Throwable {
		
		// Payment details for Credit card
	    SelectPayment selectpayment = new SelectPayment();
	    selectpayment.selectCreditCardOption();
	    
	    CreditCardPayment payment = new CreditCardPayment();
	    //TODO - do not hardcode
	    payment.enterCardDetails(cardNumber, "06/20", 123);
	    payment.isImportantMessageDisaplyed();
	    payment.clickPayNowButton();
	    payment.invalidCardMessage();
	}
	
	//************** @Then - implementation details **************

	// Method to verify results on valid entries
	@Then("^Purchase should be successful$")
	public void purchaseSuccess() throws Throwable {
		BankDetails bankdetails = new BankDetails();
		bankdetails.enterOTP("112233");
		
		PaymentStatus paymentstatus = new PaymentStatus();
		paymentstatus.paymentStatusAction();
		
	    HomePage homepage = new HomePage();
	    homepage.verifySuccessMessage();
	}

	// Method to verify results on invalid entries
	@Then("^Purchase should be un-successful$")
	public void purchaseFailed() throws Throwable {
		BankDetails bankdetails = new BankDetails();
		bankdetails.enterOTP("112233");
		
		PaymentStatus paymentstatus = new PaymentStatus();
		paymentstatus.paymentStatusAction();
	}
}
