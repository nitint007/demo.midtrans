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

import cucumber.api.Scenario;

/**
 * @author nitinthite
 * Parent class of all classes
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
			driver = new ChromeDriver();
			
			// To maximise the browser
			driver.manage().window().maximize(); 
			
			// To open the URL in browser window
			driver.get(BASEURL);
			
			// Describing default wait time for each element in tests
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		}
		return driver;
	}
}
