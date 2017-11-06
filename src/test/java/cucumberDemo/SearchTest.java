package cucumberDemo;


import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SearchTest {
	WebDriver driver;
	private String username;
	private static final String URL = "https://www.facebook.com";

	private Context context;
	
	public SearchTest(Context context) {
		this.context = context;
	}
	
	@When("^I Login facebook$")
	public void i_Login_facebook() {
		driver = context.getDriver();
		driver.get(URL);
		
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


}
