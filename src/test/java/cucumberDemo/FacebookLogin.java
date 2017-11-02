package cucumberDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;

public class FacebookLogin {
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "pass")
	WebElement pass;
	
	@FindBy(id = "loginbutton")
	WebElement loginButton;
	
	public FacebookLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		email.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
	}
}
