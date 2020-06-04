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
public class PaymentStatus {
	
	public void assertTransactionStatus() {
		
		OrderSummary ordersummary = new OrderSummary();
		ordersummary.switchToOrderSummaryFrame();
		
		Assert.assertTrue("*** Transaction message NOT displayed", paymentStatus().isDisplayed());
		System.out.println("Transsaction status message :" +paymentStatusMessage());
	}

	public void refreshPage() {
		
		if (paymentStatusMessage().contains("RETRY"))
		{
			System.out.println("Payment status button displayed to :"+paymentStatusMessage());
			WebSetup.getDriver().navigate().refresh();
		}
		else {
			paymentStatus().click();
		}
	}
	
	private WebElement paymentStatus() {

		return WebSetup.getDriver().findElement(By.xpath("//a[@class='button-main-content']//span"));
	}
	
	private String paymentStatusMessage() {

		return paymentStatus().getText();
	}
	
	
}
