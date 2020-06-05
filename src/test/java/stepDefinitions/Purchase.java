/**
 * 
 */
package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

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
public class Purchase extends WebSetup{
	
	HomePage homepage;
	CartPanel cartPanel;
	OrderSummary ordersummary;
	SelectPayment selectpayment;
	BankDetails bankdetails;
	PaymentStatus paymentstatus;
	CreditCardPayment payment;
	
	// Class constructor to initialising same properties as parent constructor
	public Purchase() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//************** Cucumber Hooks @Before - to execute a suite precondition **************
	
	@Before
	public void beforeAllScenarios(Scenario s)  {
		System.out.println("Inside Hooks @Before");
		setUp();
	}
	
	//************** Junit Hook @After - to execute a common closure code **************
	
		@AfterClass
		public void closeDriverInstance() {
			
			// To close webdriver session
			driver.quit();
		}
	
	//************** @Given - implementation details **************
	
	// Method that is common and a pre-condition for scenarios
	@Given("^User adds pillow to the cart$")
	public void itemAddedToCart() throws Throwable {
		
		// Creating Page object for accessing respective methods
		homepage = new HomePage();
		
		// Steps for adding item to cart and verifying same
		homepage.clickBuyNowButton();
		
		cartPanel = new CartPanel();
		cartPanel.clickCheckoutButton();
		
		ordersummary = new OrderSummary();
		ordersummary.clickContinue();
	}

	//************** @When - implementation details **************
	
	// Method for entering valid details for purchase
	@When("^Entered valid details$")
	public void enterValidDetails() throws Throwable {
		
		// Payment details for Credit card
	    selectpayment = new SelectPayment();
	    selectpayment.selectCreditCardOption();
	    
	    payment = new CreditCardPayment();
	    
	    //TODO - do not hardcode
	    payment.enterCardDetails(properties.getProperty("validCardNumber"), 
	    		properties.getProperty("expiryDate"), properties.getProperty("cvv"));
	    payment.importantMessageDisaplyed();
	    payment.clickPayNowButton();
	}
	
	// Method for entering invalid details for purchase
	@When("^Entered invalid details (\\d+)$")
	public void enterInvalidDetails(String cardNumber) throws Throwable {
		
		// Payment details for Credit card
	    selectpayment = new SelectPayment();
	    selectpayment.selectCreditCardOption();
	    
	    payment = new CreditCardPayment();
	    payment.enterCardDetails(cardNumber, properties.getProperty("expiryDate"), 
	    		properties.getProperty("cvv"));
	    payment.importantMessageDisaplyed();
	    payment.clickPayNowButton();
	}
	
	//************** @Then - implementation details **************

	// Method to verify results on valid entries
	@Then("^Purchase should be successful$")
	public void purchaseSuccess() throws Throwable {
		
		//TODO remove hard coded
		bankdetails = new BankDetails();
		bankdetails.enterOTP(properties.getProperty("otp"));
		
	    homepage = new HomePage();
	    homepage.verifySuccessMessage();
	}

	// Method to verify results on invalid entries
	@Then("^Purchase should be un-successful$")
	public void purchaseFailed() throws Throwable {
		bankdetails = new BankDetails();
		bankdetails.enterOTP(properties.getProperty("otp"));
		
		paymentstatus = new PaymentStatus();
		paymentstatus.paymentStatusAction();
	}
}