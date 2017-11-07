package cucumberDemo;


import static org.junit.Assert.assertTrue;
import java.text.DateFormat;
import org.openqa.selenium.By;
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
		FacebookWelcome fb = new FacebookWelcome(driver);
		fb.goToFriendsPage();;
	}

	@Then("^I should see friends page$")
	public void i_should_see_friends_page() {
	    
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(friendsPath)));
		WebElement friends = driver.findElement(By.xpath(friendsPath));
		assertTrue(friends.isDisplayed());
	}
	@When("^I post a status saying \"([^\"]*)\"$")
	public void i_post_a_status_saying(String arg1) throws InterruptedException  {
		FacebookWelcome fb = new FacebookWelcome(driver);
		fb.goHome();
		Thread.sleep(2000);
		FacebookHome fbh = new FacebookHome(driver);
		fbh.makePost(arg1);
		
		

	}
	
	@Then("^I should see status with \"([^\"]*)\"$")
	public void i_should_see_status_with(String arg1) throws InterruptedException {
		Thread.sleep(2000);
		
		FacebookWelcome fbh = new FacebookWelcome(driver);
		fbh.goToMyProfile();
		
		Thread.sleep(3000);
		FacebookProfile fbp = new FacebookProfile(driver);
		
		String actual = fbp.getPostText().getText();
		String expected = arg1;
		Assert.assertEquals(expected, actual);
	}

	

	
	
	
	



}
