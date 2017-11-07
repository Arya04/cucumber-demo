package cucumberDemo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookWelcome {
	WebDriver driver;
	
	
	@FindBy(name = "q")
	WebElement searchBar;
	
	@FindBy(xpath = ".//*[@id='navItem_1434659290104689']/a/div")
	WebElement groupsPage;
	
	@FindBy(xpath = ".//*[@id='navItem_1572366616371383']/a/div")
	WebElement friendsPage;
	
	@FindBy(id = "u_0_d")
	@CacheLookup
	WebElement home;
	
	
	@FindBy(id = "profile_pic_header_100022818877835")
	@CacheLookup
	WebElement myProfile;
	
	public FacebookWelcome(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//search whatever in the search bar
	public void search(String query) {
		searchBar.sendKeys(query);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	//navigate to groups page
	public void goToGroupsPage() {
		groupsPage.click();
	}
	
	public void goToFriendsPage() {
		friendsPage.click();
	}
	public void goHome() {
		home.click();
	}
	
	public void goToMyProfile() {
		myProfile.click();
	}
	
}
