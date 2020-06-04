/**
 * 
 */
package pageobjects;

import java.util.List;

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
		
		WebSetup.getDriver().switchTo().frame(orderSummaryFrame());
		System.out.println("*** Switched to Order Summary iFrame");
	}

	public void verifyOrderSummaryAmount() {

		HomePage.orderSummaryAmount = Integer.parseInt(orderSummaryAmount().getText());
		System.out.println("Item amount on Summary :" + HomePage.orderSummaryAmount);

		Assert.assertEquals("*** Order summary is correct as per Product and Cart amount.", HomePage.orderSummaryAmount,
				HomePage.expectedCartTotalAmount);

		Assert.assertEquals("*** Order summary is NOT correct as per Product and Cart amount.", HomePage.orderSummaryAmount,
				HomePage.actualProductAmount);
	}

	public void clickContinue() {
		
		Assert.assertTrue("*** Continue button is not enabled", continueButton().isEnabled());
		continueButton().click();
	}

	// ******** Element locators listed below for the Order Summary - are used by methods above ********
	private WebElement orderSummaryFrame() {
		
		return WebSetup.getDriver().findElement(By.id("snap-midtrans"));
	}
	
	private WebElement orderSummary() {
		
		return WebSetup.getDriver().findElement(By.xpath("//*[text()='Order Summary']"));
	}
	
	private WebElement orderSummaryAmount() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='amount-content pull-right']//span[2]"));
	}

	private WebElement continueButton() {

		return WebSetup.getDriver().findElement(By.xpath("//a[@class='button-main-content']"));
	}

}
