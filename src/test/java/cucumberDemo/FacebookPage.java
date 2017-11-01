package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class FacebookPage {
	WebElement email;
	WebElement pass;
	WebElement loginButton;
	WebElement profile;
	
	WebElement search;
	
	
	private WebDriver driver;
	private static final String URL = "https://www.facebook.com";
	
	public FacebookPage(WebDriver d) {
	//	driver = new FirefoxDriver();
	//	driver.manage().window().maximize();
	//  driver.get(URL);
		this.driver = d;
		
		
	}
	
	public void login(String username, String password) {
		email = driver.findElement(By.id("email"));
		pass = driver.findElement(By.id("pass"));
		email.sendKeys(username);
		pass.sendKeys(password);
		loginButton = driver.findElement(By.id("loginbutton"));
		loginButton.click();
		
	}
	public void assertHome() {
		profile = driver.findElement(By.id("profile_pic_header_100022818877835"));
		Assert.assertTrue(profile.isDisplayed());
	}
	
	public void findUser(String name) {
		search = driver.findElement(By.id("q"));
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
		
		
	}
}
