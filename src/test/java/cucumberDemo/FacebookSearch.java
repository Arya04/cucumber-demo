package cucumberDemo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookSearch {
	
	@FindBy(xpath = ".//*[@id='xt_uniq_3']/div/div[1]/a/div")
	WebElement someonesProfile;
	
	@FindBy(name = "q")
	WebElement searchBar;
	
	public FacebookSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void goToProfile() {
		someonesProfile.click();
	}
	
	public void search(String query) {
		searchBar.sendKeys(query);
		searchBar.sendKeys(Keys.ENTER);
	}
	

}
