/**
 * Package containing page specific elements and respective methods
 */
package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import setup.WebSetup;

/**
 * @author nitinthite
 * Class contains element locators and respective methods of from HomePage
 */
public class HomePage {
	
	public HomePage() {
		verifyHomePage();
	}

	public void verifyHomePage() throws NoSuchWindowException {
		
		try {
			if (homePage().isDisplayed()) {
				System.out.println("User is on Home page");
			}
			else {
				System.out.println("Switching driver handle to default window in case it is focused on frame.");
//				WebSetup.driver.switchTo().defaultContent();
				}
		}catch(NoSuchWindowException nswe) {
			nswe.printStackTrace();
		}
	}

	public void clickBuyNowButton() {
		
		Assert.assertTrue("*** Buy Now Button is not Accessible", buyNowButton().isDisplayed());
		
		buyNowButton().click();
	}
	
	public void verifySuccessMessage() {
		
		Assert.assertTrue("*** Purchase Success message NOT displayed.", thankyouMessage().isDisplayed());
	}

	
	// ******** Element locators listed below for the Home page - are used by methods above ********
	private WebElement homePage() {
		
		return WebSetup.driver.findElement(By.xpath("//*[text()='Midtrans Pillow']"));
	}

	private WebElement buyNowButton() {
		
		return WebSetup.driver.findElement(By.xpath("//*[@class='btn buy']"));
	}
	
	private WebElement thankyouMessage() {
		
		return WebSetup.driver.findElement(By.xpath("//*[text()='Thank you for your purchase.']"));
	}
}