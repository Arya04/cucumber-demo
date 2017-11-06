package cucumberDemo;


import static org.junit.Assert.assertTrue;

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
	
	



}
