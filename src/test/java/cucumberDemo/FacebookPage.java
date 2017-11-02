package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class FacebookPage {
	WebElement email;
	WebElement pass;
	WebElement loginButton;
	WebElement profile;
	WebElement profPic;
	WebElement post;
	WebElement search;
	WebElement home;
	WebElement coverTitle;
	
	WebElement groupsPage;
	
	private String username;
	
	private WebDriver driver;
	private static final String URL = "https://www.facebook.com";
	
	public FacebookPage() {
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		driver.manage().window().maximize();
		driver.get(URL);
		
		
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
		username = name.toLowerCase();
		
		WebDriverWait wait =new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		search = driver.findElement(By.name("q"));
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
		
	}
	public void goToProfile() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='xt_uniq_3']/div/div[1]/a/div")));
		
		profPic = driver.findElement(By.xpath(".//*[@id='xt_uniq_3']/div/div[1]/a/div"));
		profPic.click();
		
	}
	public void assertUser() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='fb-timeline-cover-name']")));
		
		coverTitle = driver.findElement(By.xpath(".//*[@id='fb-timeline-cover-name']"));
		String title = coverTitle.getText().toLowerCase();
		Assert.assertEquals(title, username);
	}
	public void goToGroupsPage() {
		//home = driver.findElement(By.xpath(".//*[@id='u_0_d']"));
		//home.click();
		groupsPage = driver.findElement(By.xpath(".//*[@id='navItem_1434659290104689']/a/div"));
		groupsPage.click();
		
	
	}
	public void assertPage() {
		String page = driver.getCurrentUrl();
		Assert.assertEquals(page, URL +"/groups/");
	}

}
