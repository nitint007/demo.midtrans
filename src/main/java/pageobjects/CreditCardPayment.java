/**
 * 
 */
package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		
		System.out.println(creditCardPaymentTitle().getText());
	}

	public void isImportantMessageDisaplyed() {

		Assert.assertTrue("*** IMPORTANT MESSAGE not displayed", importantMessage().isDisplayed());

		System.out.println("Message displayed as :: " + importantMessage().getText());
	}

	// Method to verify if amount payable on credit card popup is correct
	public void assertAmountPayable() {

		Assert.assertTrue("*** Amount Payable on Credit card popup not displayed",
				amountPayableOnCreditCardPopup().isDisplayed());

		HomePage.finalAmountPayable = Integer.parseInt(amountPayableOnCreditCardPopup().getText());
		System.out.println("Final amount payable Credit Card Popup:" + HomePage.finalAmountPayable);

		Assert.assertEquals("*** Final payable amount on Credit card popup is not same as Order Summary",
				HomePage.finalAmountPayable, HomePage.orderSummaryAmount);
	}

	public void enterCardDetails(String cardNumber, String expDate, int cvv) {

		enterCreditCardNumber(cardNumber);
		enterCreditCardExpiryDate(expDate);
		enterCreditCardCVV(cvv);
	}

	public void clickPayNowButton() {

		Assert.assertTrue("*** Pay Now button is not Enabled", payNowButton().isEnabled());

		payNowButton().click();
	}
	
	public void assertInvalidCardMessage() {

		Assert.assertTrue("*** Invalid card details message NOT displayed", 
				invalidCardDetailsMessage().isDisplayed());

		System.out.println("Message displayed on entering card number : "+invalidCardDetailsMessage().getText());
	}

	private void enterCreditCardNumber(String string) {

		Assert.assertTrue("*** Credit card number field not displayed on CreditCardPayment popup",
				creditCardNumberInputField().isDisplayed());

		// Steps for entering credit card number
		creditCardNumberInputField().click();
		creditCardNumberInputField().clear();
		creditCardNumberInputField().sendKeys(String.valueOf(string));

		Assert.assertTrue("*** Credit card number Validation not displayed",
				creditCardNumberValidation().isDisplayed());
	}

	private void enterCreditCardExpiryDate(String expiryDate) {

		Assert.assertTrue("*** Credit card Expiry Date field not displayed on CreditCardPayment popup",
				creditCardExpiryDateInputField().isDisplayed());

		// Steps for entering credit card Expiry Date
		creditCardExpiryDateInputField().click();
		creditCardExpiryDateInputField().clear();
		creditCardExpiryDateInputField().sendKeys(String.valueOf(expiryDate));
	}

	private void enterCreditCardCVV(int cvv) {

		Assert.assertTrue("*** Credit card CVV field not displayed on CreditCardPayment popup",
				creditCardCVVInputField().isDisplayed());

		// Steps for entering credit card CVV
		creditCardCVVInputField().click();
		creditCardCVVInputField().clear();
		creditCardCVVInputField().sendKeys(String.valueOf(cvv));
	}

	// ******** Element locators listed below for the CreditCardPayment page - are
	// used by methods above ********
	private WebElement creditCardPaymentTitle() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='text-page-title-content']"));
	}

	private WebElement importantMessage() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='pop']"));
	}

	private WebElement amountPayableOnCreditCardPopup() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='text-amount-amount']"));
	}

	private WebElement creditCardNumberInputField() {

		return WebSetup.getDriver().findElement(By.name("cardnumber"));
	}

	private WebElement creditCardNumberValidation() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='validation']"));
	}

	private WebElement creditCardExpiryDateInputField() {

		return WebSetup.getDriver().findElement(By.xpath("//input[@placeholder='MM / YY']"));
	}

	private WebElement creditCardCVVInputField() {

		return WebSetup.getDriver().findElement(By.xpath("//input[@placeholder='123']"));
	}

	private WebElement payNowButton() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='button-main-content']"));
	}
	
	private WebElement invalidCardDetailsMessage() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='notice danger']//span"));
	}

}
