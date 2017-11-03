package cucumberDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class FacebookTest {
	WebDriver driver;
	private String username;
	private static final String URL = "https://www.facebook.com";

	@Before
	public void setup() {
		//setup driver before logging in
		
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@When("^I Login facebook$")
	public void i_Login_facebook() {
		
		FacebookLogin fb = new FacebookLogin(driver);
	    fb.login("al3xstar@yahoo.com", "password123!");

	}

	@And("^I search \"([^\"]*)\"$")
	public void i_search(String user) {
		username = user.toLowerCase();
		
		FacebookHome fb = new FacebookHome(driver);
		fb.search(user);
	}

	@Then("^I go user profile$")
	public void i_go_user_profile() {
		//search results page to navigate to profile
		FacebookSearchResults fb = new FacebookSearchResults(driver);
		fb.goToProfile();
		
		//get profile info to check if on correct profile
		FacebookProfile profile = new FacebookProfile(driver);
		Assert.assertEquals(username,profile.getCoverTitle().getText().toLowerCase());
		
	}

	@When("^I go to groups page$")
	public void i_go_to_groups_page() {
		FacebookHome fb = new FacebookHome(driver);
		fb.goToGroupsPage();
	}

	@Then("^I should see groups page$")
	public void i_should_see_groups_page() {
	    String page = driver.getCurrentUrl();
	    String groups = URL + "/groups/";
		Assert.assertEquals(page, groups);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}



}
