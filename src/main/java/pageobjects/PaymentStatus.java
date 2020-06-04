/**
 * 
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.WebSetup;

/**
 * @author nitinthite
 *
 */
public class PaymentStatus {
	
	public PaymentStatus() {
		
		switchToCreditCardFrame();
	}
	
	public void switchToCreditCardFrame() {
		
		WebSetup.driver.switchTo().frame(creditCardFrame());
		System.out.println("*** Switched to Credit card payment status iFrame");
	}

	// Method to Retry transaction on failure or complete same in case Successful
	public void paymentStatusAction() {
		
		if (paymentStatusBottomText().contains("retry"))
		{	
			// Navigating back to Retry transaction
			paymentStatusButton().click();
			
			// Refreshing page for another transaction
			WebSetup.driver.navigate().refresh();
		}
		else {
			
			// To click on 'DONE' button when transaction status SUCCESSFUL
			paymentStatusButton().click();
		}
	}

	// ******** Element locators listed below for the Credit card payment status - used by methods above ********
		private WebElement creditCardFrame() {
			
			return WebSetup.driver.findElement(By.id("snap-midtrans"));
		}
	
	private WebElement paymentStatusButton() {
		
		return WebSetup.driver.findElement(By.xpath("//a[@class='button-main-content']"));
	}
	
	private WebElement paymentStatus() {
		
		return WebSetup.driver.findElement(By.xpath("//*[@class='bottom']//div"));
	}
	
	private String paymentStatusBottomText() {

		String message =  paymentStatus().getText();
		System.out.println("Transsaction status message :" +message);
		
		return message;
	}
}
