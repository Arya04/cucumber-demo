package cucumberDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Context {
	private static boolean initialized = false;
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		if(!initialized) {
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(ffprofile);
			driver.manage().window().maximize();
			initialized = true;
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void tearDownDriver() {
		initialized = false;
		driver.quit();
	}
}
