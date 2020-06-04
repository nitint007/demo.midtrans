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
public class CartPanel {
	
	protected int items;
	
	public CartPanel() {
		
		assertCartPanel();
	}


	public void assertCartPanel() {

		Assert.assertTrue("*** Cart panel is not displayed", shoppingCartPanel().isDisplayed());
		
	}

	public int ifCartHasItems() {
		
		Assert.assertTrue("*** Cart items number not displayed", cartItems().isDisplayed());

		items = Integer.parseInt(cartItems().getText());
		
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

		return WebSetup.driver.findElement(By.xpath("//*[@class='cart-head']/span[1]"));
	}

	private WebElement cartItems() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='cart-head']/span[2]"));
	}

	private WebElement checkoutButton() {

		return WebSetup.driver.findElement(By.xpath("//*[@class='cart-checkout']"));
	}

}
