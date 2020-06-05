/**
 * 
 */
package pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import setup.WebSetup;

/**
 * @author nitinthite
 *
 */
public class CreditCardPayment extends WebSetup{
	
	// Initialising objects mentioned in parent class constructor
	public CreditCardPayment() throws FileNotFoundException, IOException {

		super();
		assertCreditCardPaymentDisplayed();
	}

	// Making sure if driver reached to intended page
	public void assertCreditCardPaymentDisplayed() {

		Assert.assertTrue("*** Credit Card input fields NOT displayed", creditCardPaymentTitle().isDisplayed());
		
		System.out.println("User On :"+creditCardPaymentTitle().getText());
	}

	public void importantMessageDisaplyed() {

		Assert.assertTrue("*** IMPORTANT MESSAGE not displayed", importantMessage().isDisplayed());

		System.out.println("Message displayed as :: " + importantMessage().getText());
	}

	// Method to Enter card details
	public void enterCardDetails(String cardNumber, String expDate, String cvv) {

		enterCardDetails(cardNumber, creditCardNumberInputField());
		enterCardDetails(expDate, creditCardExpiryDateInputField());
		enterCardDetails(cvv, creditCardCVVInputField());
	}

	public void clickPayNowButton() {
		
			if (payNowButton().isEnabled()) {
				
				payNowButton().click();
			}
			else {
				
				System.out.println("*** Pay Now button is not Enabled");
				invalidCardMessage();
			}
	}
	
	// Method to check if Invalid Card Message displayed
	private void invalidCardMessage() {
		
			if(invalidCardDetailsMessage().isDisplayed())
			{
				System.out.println("Message displayed on entering card number : "+invalidCardDetailsMessage().getText());
				System.out.println("Invalid card details - navigating to Home page");
				driver.navigate().refresh();
			}
			else {
				System.out.println("Invalid card details message NOT displayed");
			}
	}
	
	// Method to enter card details
	private void enterCardDetails(String cardDetail, WebElement element) {

		Assert.assertTrue("*** Credit card number field not displayed",
				element.isDisplayed());

		// Steps for entering credit card number
		element.click();
		element.clear();
		element.sendKeys(String.valueOf(cardDetail));

		Assert.assertTrue("*** Credit card number Validation not displayed",
				creditCardNumberValidation().isDisplayed());
	}

	// ******** Element locators listed below for the CreditCardPayment page - are
	// used by methods above ********
	private WebElement creditCardPaymentTitle() {

		return driver.findElement(By.xpath("//*[@class='text-page-title-content']"));
	}

	private WebElement importantMessage() {

		return driver.findElement(By.xpath("//*[@class='pop']"));
	}

	private WebElement creditCardNumberInputField() {

		return driver.findElement(By.name("cardnumber"));
	}

	private WebElement creditCardNumberValidation() {

		return driver.findElement(By.xpath("//*[@class='validation']"));
	}

	private WebElement creditCardExpiryDateInputField() {

		return driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
	}

	private WebElement creditCardCVVInputField() {

		return driver.findElement(By.xpath("//input[@placeholder='123']"));
	}

	private WebElement payNowButton() {

		return driver.findElement(By.xpath("//*[@class='button-main-content']"));
	}
	
	private WebElement invalidCardDetailsMessage() {

		return driver.findElement(By.xpath("//*[@class='notice danger']//span"));
	}

}
