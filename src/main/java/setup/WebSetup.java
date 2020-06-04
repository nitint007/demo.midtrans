/**
 * 
 */
package setup;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author nitinthite
 *
 */
public class WebSetup {

	// Webdriver instance for easy access
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	//Target website url for test that is fixed
	private static final String BASEURL = "https://demo.midtrans.com/";

	/*
	 * Method details out configuration for chrome browser
	 */
	public static WebDriver setUp() {
		
		if (driver == null ) {
			
			System.out.println("Setup method call");
			
			// To create new instance of chrome driver
			setDriver(new ChromeDriver());
			
			// To maximise the browser
			getDriver().manage().window().maximize(); 
			
			// To open the URL in browser window
			getDriver().get(BASEURL);
			
			// Describing default wait time for each element in tests
			getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		return driver;
	}

	//Method to access webdriver instance created
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		WebSetup.driver = driver;
	}
	
	public static WebDriverWait driverWait() {
		
		return wait = new WebDriverWait(driver, 30);
	}
}
