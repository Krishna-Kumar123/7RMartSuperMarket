package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") WebElement signinButton;
	@FindBy(xpath="//li[text()='Dashboard']") WebElement dashboardvalue;
	@FindBy(xpath="//*[contains(text(),'Alert')]") WebElement loginFailed;
	
	public void enterUserNameOnUserNameField(String username) {
		
		usernameField.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password) {
		
		passwordField.sendKeys(password);
	}
	public void clickOnSignInButton() {
		
		signinButton.click();
	}
	
	public boolean isDashboardLoaded() {
		return dashboardvalue.isDisplayed();
	
	}
	
	public boolean isLoginFailed() {
		return loginFailed.isDisplayed();
	
	}
}
