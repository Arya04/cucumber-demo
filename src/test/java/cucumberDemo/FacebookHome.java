package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class FacebookHome {
	WebDriver driver;
	WebElement msg;
	WebElement btn;
	
	@FindBy(css = "span[class='uiIconText _5qtp']")
	WebElement post;
	
	public FacebookHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void makePost(String arg1) throws InterruptedException {
		post.click();
		Thread.sleep(3000);
		msg = driver.findElement(By.cssSelector("div[class='notranslate _5rpu']"));
		msg.sendKeys(arg1);
		
		btn = driver.findElement(By.cssSelector("button[class='_1mf7 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']"));
		btn.click();
	}

}
