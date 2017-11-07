package cucumberDemo;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	@When("^I post a status$")
	public void i_post_a_status() throws IOException {
		WebElement home = driver.findElement(By.id("u_0_d"));
		home.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='navItem_1572366616371383']/a/div")));
		captureScreenShots("example");
		
		
		System.out.println(driver.getPageSource());
		
		//WebElement  post = driver.findElement(By.cssSelector("div._1mwp.navigationFocus._395._1mwq._4c_p._5bu_._34nd._21mu._5yk1"));
		//post.click();
		//post.sendKeys("hello");
		//driver.findElement(By.xpath(".//*[@id='js_sl']/div[2]/div[3]/div/div[2]/div/button")).click();
		
	}

	@Then("^I should see status$")
	public void i_should_see_status() {
		
	}
	public void captureScreenShots(String fileName) throws IOException {
		folder_name = "screenshot";
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Date format for screenshot file name
		df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// create dir with given folder name
		new File(folder_name).mkdir();
		// Setting file name
		String file_name = fileName + df.format(new Date()) + ".png";
		// copy screenshot file into screenshot folder.
		String file_new = folder_name + "/" + file_name;
		FileUtils.copyFile(f, new File(file_new));
	}
	
	



}
