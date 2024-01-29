package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;


public class DashboardTest extends Base {
	
	@Test
	public void verifyTheUserIsAbleToNavigateToManageDeliveryBoyPage() {
		
		String usernameValue = "admin";
		String passwordValue = "admin";
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		dashboardPage.clickManageDeliveryBoy();
		boolean isListDeliveryBoyPageLoaded =dashboardPage.isManageDeliveryBoyPageLoaded();
		assertTrue(isListDeliveryBoyPageLoaded,"Unable to load List delivery boy page");
	}

}
