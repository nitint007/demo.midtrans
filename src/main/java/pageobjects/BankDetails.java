/**
 * 
 */
package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import setup.WebSetup;

/**
 * @author nitinthite
 *
 */
public class BankDetails {

	public BankDetails() {

		goToIssuingBankFrame();
	}

	public void goToIssuingBankFrame() {
		
		try {
			WebSetup.getDriver().switchTo().frame(issuingBankiFrame());
			System.out.println("*** Switched to Issuing Bank iFrame");
		} catch (NoSuchWindowException nswe) {
		}
	}

	public void enterOTP(String otp) throws InterruptedException {

		Assert.assertTrue("*** OTP field is not Displayed", enterOTPField().isDisplayed());

		enterOTPField().click();
		enterOTPField().clear();
		enterOTPField().sendKeys(otp);

		// Submitting Bank OTP
		enterOTPField().submit();

		WebSetup.getDriver().switchTo().defaultContent();
		System.out.println("Switched to Default content");
	}

	// ******** Element locators listed below for the Bank Details - are used by
	// methods above ********
	private WebElement enterOTPField() throws InterruptedException {

		Thread.sleep(10000);
//		WebElement otpField = WebSetup.wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));

		return WebSetup.getDriver().findElement(By.xpath("//input[@type='password']"));
	}

	private WebElement issuingBankiFrame() {
	
		return WebSetup.getDriver().findElement(By.xpath("//*[@class='main-container']//iframe"));
	}

}
