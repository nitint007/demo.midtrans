/**
 * 
 */
package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author nitinthite
 * Class to provide common methods of seleniumWebdriver used in suite
 */
public class Commons {
	
	public static WebElement findByXpath(String elementXpath) {
		
		return WebSetup.driver.findElement(By.xpath(elementXpath));
	}

}
