package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookProfile {
	WebDriver driver;
	WebElement coverTitle;
	
	public FacebookProfile(WebDriver driver) {
		this.driver = driver;
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='fb-timeline-cover-name']")));
		//initialize webelement in constructor because of necessary wait which cant be done with FindBy
		coverTitle = driver.findElement(By.xpath(".//*[@id='fb-timeline-cover-name']"));
	}
	//return webelement to check title for test
	public WebElement getCoverTitle() {
		return coverTitle;
	}
}
