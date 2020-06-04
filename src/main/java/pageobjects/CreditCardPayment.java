/**
 * 
 */
package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import cucumber.api.java.it.Date;
import setup.WebSetup;

/**
 * @author nitinthite
 *
 */
public class CreditCardPayment {

	public CreditCardPayment() {

		assertCreditCardPaymentDisplayed();
	}

	public void assertCreditCardPaymentDisplayed() {

		Assert.assertTrue("*** Credit Card input fields NOT displayed", creditCardPaymentTitle().isDisplayed());
		
		System.out.println("User On :"+creditCardPaymentTitle().getText());
	}

	public void isImportantMessageDisaplyed() {

		Assert.assertTrue("*** IMPORTANT MESSAGE not displayed", importantMessage().isDisplayed());

		System.out.println("Message displayed as :: " + importantMessage().getText());
	}

	public void enterCardDetails(String cardNumber, String expDate, int cvv) {

		enterCardDetails(cardNumber);
		enterCardExpiryDate(expDate);
		enterCardDetails(cvv);
	}

	public void clickPayNowButton() {

		Assert.assertTrue("*** Pay Now button is not Enabled", payNowButton().isEnabled());

		payNowButton().click();
	}
	
	public void invalidCardMessage() throws NoSuchElementException {
		
		try {
			if(invalidCardDetailsMessage().isDisplayed())
			{
				System.out.println("Message displayed on entering card number : "+invalidCardDetailsMessage().getText());
				System.out.println("Invalid card details - navigating to Home page");
				WebSetup.driver.navigate().refresh();
			}
			else {
				System.out.println("Invalid card details message NOT displayed");
			}
		}catch(NoSuchElementException nse) {
			System.out.println("Element does not always appear, hence continue.");
		}
	}

	private void enterCardDetails(String string) {

		Assert.assertTrue("*** Credit card number field not displayed",
				creditCardNumberInputField().isDisplayed());

		// Steps for entering credit card number
		creditCardNumberInputField().click();
		creditCardNumberInputField().clear();
		creditCardNumberInputField().sendKeys(String.valueOf(string));

		Assert.assertTrue("*** Credit card number Validation not displayed",
				creditCardNumberValidation().isDisplayed());
	}

	private void enterCardExpiryDate(String expiryDate) {

		Assert.assertTrue("*** Credit card Expiry Date field not displayed",
				creditCardExpiryDateInputField().isDisplayed());

		// Steps for entering credit card Expiry Date
		creditCardExpiryDateInputField().click();
		creditCardExpiryDateInputField().clear();
		creditCardExpiryDateInputField().sendKeys(String.valueOf(expiryDate));
	}

	private void enterCardDetails(int cvv) {

		Assert.assertTrue("*** Credit card CVV field not displayed",
				creditCardCVVInputField().isDisplayed());

		// Steps for entering credit card CVV
		creditCardCVVInputField().click();
		creditCardCVVInputField().clear();
		creditCardCVVInputField().sendKeys(String.valueOf(cvv));
	}

	// ******** Element locators listed below for the CreditCardPayment page - are
	// used by methods above ********
	private WebElement creditCardPaymentTitle() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='text-page-title-content']"));
	}

	private WebElement importantMessage() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='pop']"));
	}

	private WebElement creditCardNumberInputField() {

		return WebSetup.driver.findElement(By.name("cardnumber"));
	}

	private WebElement creditCardNumberValidation() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='validation']"));
	}

	private WebElement creditCardExpiryDateInputField() {

		return WebSetup.driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
	}

	private WebElement creditCardCVVInputField() {

		return WebSetup.driver.findElement(By.xpath("//input[@placeholder='123']"));
	}

	private WebElement payNowButton() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='button-main-content']"));
	}
	
	private WebElement invalidCardDetailsMessage() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='notice danger']//span"));
	}

}
