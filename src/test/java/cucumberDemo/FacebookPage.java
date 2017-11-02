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
	WebElement search;
	
	WebElement coverTitle;
	WebElement groupsPage;
	
	private String username;
	private WebDriver driver;
	private static final String URL = "https://www.facebook.com";
	
	public FacebookPage() {
		//Firefox profile to disable push notifications
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public void login(String username, String password) {
		//find email and password elements
		email = driver.findElement(By.id("email"));
		pass = driver.findElement(By.id("pass"));
		//login credentials
		email.sendKeys(username);
		pass.sendKeys(password);
		//login
		loginButton = driver.findElement(By.id("loginbutton"));
		loginButton.click();
		
		
	}
	public void assertHome() {
		profile = driver.findElement(By.id("profile_pic_header_100022818877835"));
		Assert.assertTrue(profile.isDisplayed());
	}
	
	public void findUser(String name) {
		username = name.toLowerCase();
		//wait until search bar is located
		WebDriverWait wait =new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		//search name entered into search bar
		search = driver.findElement(By.name("q"));
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
		
		
	}
	public void goToProfile() {
		//wait until profile is loaded on search page
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='xt_uniq_3']/div/div[1]/a/div")));
		
		profPic = driver.findElement(By.xpath(".//*[@id='xt_uniq_3']/div/div[1]/a/div"));
		profPic.click();
		
	}
	public void assertUser() {
		//wait until user profile is loaded
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='fb-timeline-cover-name']")));
		
		//check if user profile name is equal to username searched
		coverTitle = driver.findElement(By.xpath(".//*[@id='fb-timeline-cover-name']"));
		String title = coverTitle.getText().toLowerCase();
		Assert.assertEquals(title, username);
	}
	public void goToGroupsPage() {
		//go to groups page
		groupsPage = driver.findElement(By.xpath(".//*[@id='navItem_1434659290104689']/a/div"));
		groupsPage.click();
		
	
	}
	public void assertGroups() {
		//check if page is on groups page
		String page = driver.getCurrentUrl();
		String groups = URL + "/groups/";
		Assert.assertEquals(page, groups);
	}

}
