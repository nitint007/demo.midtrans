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
public class SelectPayment {
	
	public SelectPayment() {
		
		assertSelectPaymentDisplayed();
	}

	public void assertSelectPaymentDisplayed() {
		
		Assert.assertTrue("*** Select CreditCardPayment popup is not displayed", selectPaymentPopup().isDisplayed());
	}

	public void isCreditCardOptionDisplayed() {
		
		Assert.assertTrue("*** Credit Card option not displayed", creditCardOption().isDisplayed());
	}

	public void selectCreditCardOption() {
		isCreditCardOptionDisplayed();

		creditCardOption().click();
	}

	// ******** Element locators listed below for the SELECT PAYMENT TYPE - are used by methods above ********
	private WebElement selectPaymentPopup() {

		return WebSetup.getDriver().findElement(By.id("payment-list"));
	}

	private WebElement creditCardOption() {

		return WebSetup.getDriver().findElement(By.xpath("//a[@href='#/credit-card']"));
	}
}
