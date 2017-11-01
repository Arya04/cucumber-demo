package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookTest {
	WebDriver driver = null;
	
	@Given("^I've opened facebook$")
	public void i_ve_opened_facebook() throws Exception {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}


	@When("^I enter valid username and valid password$")
	public void i_enter_valid_username_and_valid_password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("al3xstar@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("password123!");
	}

	@Then("^I login successfully$")
	public void i_login_successfully() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
	}


}
