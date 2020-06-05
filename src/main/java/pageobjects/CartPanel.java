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
 *
 */
public class CartPanel extends WebSetup {
	
	// Initialising objects mentioned in parent class constructor
	public CartPanel() throws FileNotFoundException, IOException {
		
		super();
		assertCartPanel();
	}

	// Making sure if driver reached to intended page
	public void assertCartPanel() {

		Assert.assertTrue("*** Cart panel is not displayed", shoppingCartPanel().isDisplayed());
		
	}

	// Fetching number of items added to cart
	public int ifCartHasItems() {
		
		Assert.assertTrue("*** Cart items number not displayed", cartItems().isDisplayed());

		int items = Integer.parseInt(cartItems().getText());
		
		return items;
	}

	public void clickCheckoutButton() {
		
		if (ifCartHasItems() >= 1) {
			
			Assert.assertTrue("*** Checkout Button not displayed", checkoutButton().isDisplayed());

			checkoutButton().click();
		}
		else {
			System.out.println("*** Cart is Empty!!!");
		}
	}

	// ******** Element locators listed below for the CART PANEL - are used by methods above ********
	private WebElement shoppingCartPanel() {

		return driver.findElement(By.xpath("//*[@class='cart-head']/span[1]"));
	}

	private WebElement cartItems() {

		return driver.findElement(By.xpath("//*[@class='cart-head']/span[2]"));
	}

	private WebElement checkoutButton() {

		return driver.findElement(By.xpath("//*[@class='cart-checkout']"));
	}

}