package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSearchResults {
	
	
	WebDriver driver;
	WebElement profile;
	
	public FacebookSearchResults(WebDriver driver) {
		this.driver = driver;
		
		String profxpath = ".//*[@id='xt_uniq_3']/div/div[1]/a/div";

		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(profxpath)));
		//initialize search result in constructor because of the wait needed
		profile = driver.findElement(By.xpath(profxpath));
	}
	//go to profile page
	public void goToProfile() {
		
		profile.click();
	}
	
	
	

}
