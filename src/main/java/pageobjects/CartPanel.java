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
public class CartPanel extends HomePage {
	
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

	public void verifyCartAmount() {

		ifCartHasItems();

		Assert.assertTrue("*** Item price not displayed on Cart Panel", itemPriceOnCart().isDisplayed());

		int productPriceOnCart = Integer.parseInt(itemPriceOnCart().getText());

		Assert.assertEquals("*** Amount on cart for item is NOT equal as Product price.", productPriceOnCart,
				productAmount);
	}

	public boolean isCartInfoCorrect() {
		
		verifyCartAmount();
		Assert.assertTrue("*** Total amount not displayed", totalAmount().isDisplayed());

		totalCartItems = Integer.parseInt(cartItems().getText());

		actualProductAmount = getset.getProductActualPrice() * totalCartItems;
		expectedCartTotalAmount = Integer.parseInt(totalAmount().getText()) * totalCartItems;

		Assert.assertEquals("*** Amount in cart for item not as expected.", actualProductAmount,
				expectedCartTotalAmount);

		boolean isEqual = false;

		if (expectedCartTotalAmount == actualProductAmount) {
			isEqual = true;
			System.out.println("Item cart amount correct.");
		} else {
			isEqual = false;
			System.out.println("Item cart amount NOT correct.");
		}

		return isEqual;
	}

	public void clickCheckoutButton() {
		Assert.assertTrue("*** Checkout Button not displayed", checkoutButton().isDisplayed());

		checkoutButton().click();
	}

	// ******** Element locators listed below for the CART PANEL - are used by methods above ********
	private WebElement shoppingCartPanel() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='cart-head']/span[1]"));
	}

	private WebElement cartItems() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='cart-head']/span[2]"));
	}

	private WebElement totalAmount() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='table']//tbody/tr[2]/td[3]"));
	}

	private WebElement itemPriceOnCart() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='price']//span[2]"));
	}

	private WebElement checkoutButton() {

		return WebSetup.getDriver().findElement(By.xpath("//*[@class='cart-checkout']"));
	}

}
