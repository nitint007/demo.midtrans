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
 * Class contains web elements and respective methods for Select Payment Type frame 
 */
public class SelectPayment extends WebSetup {
	
	// Class constructor to initialising same properties as parent constructor
	public SelectPayment() throws FileNotFoundException, IOException {
		
		super();
		assertSelectPaymentDisplayed();
	}

	// Making sure if driver reached to intended page
	public void assertSelectPaymentDisplayed() {
		
		Assert.assertTrue("*** Select Credit Card Payment not displayed", selectPaymentPop().isDisplayed());
	}

	public void isCreditCardOptionDisplayed() {
		
		Assert.assertTrue("*** Credit Card option not displayed", creditCardOption().isDisplayed());
	}

	public void selectCreditCardOption() {
		
		isCreditCardOptionDisplayed();

		creditCardOption().click();
	}

	// ******** Element locators listed below for the SELECT PAYMENT TYPE - are used by methods above ********
	private WebElement selectPaymentPop() {

		return driver.findElement(By.id("payment-list"));
	}

	private WebElement creditCardOption() {

		return driver.findElement(By.xpath("//a[@href='#/credit-card']"));
	}
}
