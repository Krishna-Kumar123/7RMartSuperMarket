package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(description = "Verify whether user is able to login with valid username and valid password")	
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() {
		
		String usernameValue = ExcelUtility.getString(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getString(1, 0, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		boolean isHomePageLoaded =loginpage.isDashboardLoaded();
		assertTrue(isHomePageLoaded,"Home page not loaded when user is entering valid credentials");
		
	}
	@Test(description = "Verify whether user is able to login with valid username and invalid password")
	public void verifyTheUserIsNotAbleToLoginUsingValidUsernameAndInvalidPassword() {
		
		String usernameValue = ExcelUtility.getString(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getString(1, 3, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		boolean isInvalidLogin =loginpage.isLoginFailed();
		assertTrue(isInvalidLogin,"Alert is not loaded when user is entering valid username and invalid password");
		
	}
	@Test(description = "Verify whether user is able to login with invalid username and invalid password")
	public void verifyTheUserIsNotAbleToLoginUsingInvalidUsernameAndInvalidPassword() {
		
		String usernameValue = ExcelUtility.getString(1, 2, "LoginPage");
		String passwordValue = ExcelUtility.getString(1, 3, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		boolean isInvalidLogin =loginpage.isLoginFailed();
		assertTrue(isInvalidLogin,"Alert is not loaded when user is entering invalid username and invalid password");
		
	}
	@Test(dataProvider ="LoginProvider", description = "Verify whether user is able to login with invalid username and valid password")
	public void verifyTheUserIsNotAbleToLoginUsingInvalidUsernameAndvalidPassword(String usernameValue, String passwordValue) {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		boolean isInvalidLogin =loginpage.isLoginFailed();
		assertTrue(isInvalidLogin,"Alert is not loaded when user is entering invalid username and valid password");
		
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(1, 2, "LoginPage"), ExcelUtility.getString(1, 1, "LoginPage") },

		};
}
	
}
