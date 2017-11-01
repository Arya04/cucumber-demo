package cucumberDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookTest {
	//FacebookPage fb;
	WebDriver d;
	private static final String URL = "https://www.facebook.com";

	//@Before
	//public void setup() throws Exception{
	//	d = new FirefoxDriver();
	//	d.manage().window().maximize();
	//	d.get(URL);
	//}
	
	@Given("^I've opened facebook$")
	public void i_ve_opened_facebook() throws Throwable {
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get(URL);
		FacebookPage fb = new FacebookPage(d);
	
	}


	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String username, String password) throws Throwable {
		FacebookPage fb = new FacebookPage(d);
		fb.login(username, password);

	}

	@Then("^I login successfully$")
	public void i_login_successfully() throws Throwable {
		FacebookPage fb = new FacebookPage(d);
		fb.assertHome();
	}
	//*******SCENARIO 2************
	
	@Given("^I'm on homepage$")
	public void i_m_on_homepage() throws Throwable {
	   System.out.println("home");
	   FacebookPage fb = new FacebookPage(d);
	}

	@When("^I search for user$")
	public void i_search_for_user() throws Throwable {
		FacebookPage fb = new FacebookPage(d);
	    fb.findUser("Arya Atighehchian");
		System.out.println("nice");
	}

	@Then("^i go to user profile$")
	public void i_go_to_user_profile() throws Throwable {
	    System.out.println("there");
	}


}
