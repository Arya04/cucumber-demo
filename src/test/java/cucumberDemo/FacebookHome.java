package cucumberDemo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHome {
	
	@FindBy(name = "q")
	@CacheLookup
	WebElement searchBar;
	
	@FindBy(xpath = ".//*[@id='navItem_1434659290104689']/a/div")
	@CacheLookup
	WebElement groupsPage;
	
	public FacebookHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
	
}
