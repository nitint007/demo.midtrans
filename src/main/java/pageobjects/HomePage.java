/**
 * Package containing page specific elements and respective methods
 */
package pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import setup.WebSetup;

/**
 * @author nitinthite
 * Class contains element locators and respective methods of from HomePage
 */
public class HomePage extends WebSetup{
		
	// Class custom constructor
	public HomePage() throws FileNotFoundException, IOException {
		
		super();
		verifyHomePage();
	}

	// Verifying if driver handle reached home page
	public void verifyHomePage() throws NoSuchWindowException {
		
		try {
			if (homePage().isDisplayed()) {
				
				System.out.println("User is on Home page");
			}
			else {
				System.out.println("There is some issue with the navigation. Refreshing the page.");
				
				driver.navigate().refresh();
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
		
		return driver.findElement(By.xpath("//*[text()='Midtrans Pillow']"));
	}

	private WebElement buyNowButton() {
		
		return driver.findElement(By.xpath("//*[@class='btn buy']"));
	}
	
	private WebElement thankyouMessage() {
		
		return driver.findElement(By.xpath("//*[text()='Thank you for your purchase.']"));
	}
}