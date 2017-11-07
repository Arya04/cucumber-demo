package cucumberDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Context {
	private static boolean initialized = false;
	
	private WebDriver driver;
	private static final String BROWSER = "Firefox";
	private static final String DRIVERPATH = "c://Users/Coveros/Desktop/";
	
	@Before
	public void setup() {
		if(!initialized) {
			if(BROWSER.equals("Firefox")) {
				FirefoxProfile ffprofile = new FirefoxProfile();
				ffprofile.setPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver(ffprofile);
			}
			else {
				ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver",DRIVERPATH+"chromedriver.exe");
				driver = new ChromeDriver(ops);
			}
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
