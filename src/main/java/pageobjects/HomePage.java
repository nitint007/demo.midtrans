/**
 * Package containing page specific elements and respective methods
 */
package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import setup.WebSetup;
import util.getterSetter;

/**
 * @author nitinthite
 * Class contains element locators and respective methods of from HomePage
 */
public class HomePage {
	
	protected static int productAmount, totalCartItems, 
	actualProductAmount, expectedCartTotalAmount, 
	orderSummaryAmount, finalAmountPayable;
	
	getterSetter getset;
	
	public HomePage() {
		assertHomePage();
	}

	public void assertHomePage() {
		
		Assert.assertTrue("*** Home page is not Accessible", homePage().isDisplayed());
	}
	
	public void storeProductPrice() {
		
		Assert.assertTrue("*** Product Price not Displayed", productPrice().isDisplayed());
		
		productAmount = Integer.parseInt(productPrice().getText());
		System.out.println("Product amount displayed is "+productAmount);
		
		getset = new getterSetter();
		getset.setProductActualPrice(productAmount);
	}

	public void clickBuyNowButton() throws NoSuchElementException {
		
		Assert.assertTrue("*** Buy Now Button is not Accessible", buyNowButton().isDisplayed());
		
		buyNowButton().click();
	}
	
	public void verifySuccessMessage() {
		
		Assert.assertTrue("*** Purchase Success message NOT displayed.", thankyouMessage().isDisplayed());
	}

	
	// ******** Element locators listed below for the Home page - are used by methods above ********
	private WebElement homePage() {
		
		return WebSetup.getDriver().findElement(By.xpath("//*[text()='Midtrans Pillow']"));
	}
	
	private WebElement productPrice() {
		
		return WebSetup.getDriver().findElement(By.xpath("//*[@class='price']//span[2]"));
	}

	private WebElement buyNowButton() {
		
		return WebSetup.getDriver().findElement(By.xpath("//*[@class='btn buy']"));
	}
	
	private WebElement thankyouMessage() {
		
		return WebSetup.getDriver().findElement(By.xpath("//*[text()='Thank you for your purchase.']"));
	}
}