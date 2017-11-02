package cucumberDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookTest {
	FacebookPage fb;

	
	@When("^I Login facebook$")
	public void i_Login_facebook() {
	    fb = new FacebookPage();
	    fb.login("al3xstar@yahoo.com", "password123!");
	    
	}

	@And("^I search \"([^\"]*)\"$")
	public void i_search(String user) {
	    fb.findUser(user);
	}

	@Then("^I go user profile$")
	public void i_go_user_profile() {
		fb.goToProfile();
		fb.assertUser();
	}

	@When("^I go to groups page$")
	public void i_go_to_groups_page() {
	    fb.goToGroupsPage();
	}

	@Then("^I should see groups page$")
	public void i_should_see_groups_page() {
	    fb.assertGroups();
	}



}
