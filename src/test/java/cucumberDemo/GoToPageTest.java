package cucumberDemo;


import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GoToPageTest {
	WebDriver driver;
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
	
	



}
