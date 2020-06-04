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
public class OrderSummary {
	
	public OrderSummary () {
		
		assertOrderSummary();
	}

	public void assertOrderSummary() {
		
		switchToOrderSummaryFrame();
		Assert.assertTrue("*** Order Summmary Title not displayed", orderSummary().isDisplayed());
	}
	
	public void switchToOrderSummaryFrame() {
		
		WebSetup.driver.switchTo().frame(orderSummaryFrame());
		System.out.println("*** Switched to Order Summary iFrame");
	}

	public void clickContinue() {
		
		Assert.assertTrue("*** Continue button is not enabled", continueButton().isEnabled());
		continueButton().click();
	}

	// ******** Element locators listed below for the Order Summary - are used by methods above ********
	private WebElement orderSummaryFrame() {
		
		return WebSetup.driver.findElement(By.id("snap-midtrans"));
	}
	
	private WebElement orderSummary() {
		
		return WebSetup.driver.findElement(By.xpath("//*[text()='Order Summary']"));
	}

	private WebElement continueButton() {

		return WebSetup.driver.findElement(By.xpath("//a[@class='button-main-content']"));
	}

}
