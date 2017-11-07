package cucumberDemo;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GoToPageTest {
	WebDriver driver;
	private String friendsPath = ".//*[@id='pagelet_bookmark_seeall']/div/div/div[1]/div/div[2]/h2";
	private static final String URL = "https://www.facebook.com";
	String folder_name;
	DateFormat df;

	private Context context;
	
	public GoToPageTest(Context context) {
		this.context = context;
	}
	
	@When("^I Login to facebook$")
	public void i_Login_to_facebook() {
		driver = context.getDriver();
		driver.get(URL);
		
		FacebookLogin fb = new FacebookLogin(driver);
	    fb.login("al3xstar@yahoo.com", "password123!");

	}

	@When("^I go to friends page$")
	public void i_go_to_friends_page() {
		FacebookHome fb = new FacebookHome(driver);
		fb.goToFriendsPage();;
	}

	@Then("^I should see friends page$")
	public void i_should_see_friends_page() {
	    // String page = driver.getCurrentUrl();
	    //String groups = URL + "/groups/";
		//Assert.assertEquals(page, groups);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(friendsPath)));
		WebElement friends = driver.findElement(By.xpath(friendsPath));
		assertTrue(friends.isDisplayed());
	}
	@When("^I post a status saying \"([^\"]*)\"$")
	public void i_post_a_status_saying(String arg1) throws InterruptedException  {
		WebElement home = driver.findElement(By.id("u_0_d"));
		home.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='uiIconText _5qtp']")));
		
		WebElement  post = driver.findElement(By.cssSelector("span[class='uiIconText _5qtp']"));
		post.click();
		
		Thread.sleep(5000);
		WebElement msg = driver.findElement(By.cssSelector("div[class='notranslate _5rpu']"));
		msg.sendKeys(arg1);
		
		WebElement btn = driver.findElement(By.cssSelector("button[class='_1mf7 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']"));
		btn.click();
	}
	
	@Then("^I should see status with \"([^\"]*)\"$")
	public void i_should_see_status_with(String arg1) throws InterruptedException {
		Thread.sleep(2000);
		WebElement prof = driver.findElement(By.id("profile_pic_header_100022818877835"));
		prof.click();
		Thread.sleep(3000);
		
		
		WebElement text = driver.findElement(By.cssSelector("div[class='_5pbx userContent _22jv _3576']"));
		String actual = text.getText();
		String expected = arg1;
		Assert.assertEquals(expected, actual);
	}

	

	
	
	
	



}
