package testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ListDeliveryBoyPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ListDeliveryBoyTest extends Base{
	
	@Test(description = "Verify whether delivery boy is available in the list if we provide input with existing name and email and phone")
	public void verifySearchFunctionalityInListDeliveryBoyPage() {
		
		String name = ExcelUtility.getString(2, 0, "ListDeliveryBoySearchPage");
		String email = ExcelUtility.getString(2, 1, "ListDeliveryBoySearchPage");
		String phone = ExcelUtility.getString(2, 2, "ListDeliveryBoySearchPage");
		ListDeliveryBoyPage listdeliveryboypage = new ListDeliveryBoyPage(driver);
		String usernameValue = ExcelUtility.getString(2, 3, "ListDeliveryBoySearchPage");
		String passwordValue = ExcelUtility.getString(2, 4, "ListDeliveryBoySearchPage");
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		dashboardPage.clickManageDeliveryBoy();
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.enterNameInListDeliveryBoySearchFilter(name);
		listdeliveryboypage.enterEmailInListDeliveryBoySearchFilter(email);
		listdeliveryboypage.enterPhoneInListDeliveryBoySearchFilter(phone);
		listdeliveryboypage.clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter();
		String nameDisplayedInSearchResult = listdeliveryboypage.verifyNameLoaded();
		assertEquals(nameDisplayedInSearchResult, name,"Name displayed in the search result dosen't match with the name provided in the search input");
		String emailDisplayedInSearchResult = listdeliveryboypage.verifyEmailLoaded();
		assertEquals(emailDisplayedInSearchResult, email,"Email displayed in the search result dosen't match with the email provided in the search input");
		String phoneDisplayedInSearchResult = listdeliveryboypage.verifyPhoneLoaded();
		assertEquals(phoneDisplayedInSearchResult, phone,"Phone displayed in the search result dosen't match with the phone provided in the search input");
	}
	
	@Test(description="Verify whether user is able to add new delivery boy")
	public void verifyUserIsAbletoAddNewDeliveryBoy() {
		String usernameValue = ExcelUtility.getString(6, 4, "ListDeliveryBoySearchPage");
		String passwordValue = ExcelUtility.getString(6, 5, "ListDeliveryBoySearchPage");
		String name = ExcelUtility.getString(6, 0, "ListDeliveryBoySearchPage");
		String email = ExcelUtility.getString(6, 1, "ListDeliveryBoySearchPage");
		String phone = ExcelUtility.getString(6, 2, "ListDeliveryBoySearchPage");
		String addUsername = ExcelUtility.getString(6, 0, "ListDeliveryBoySearchPage");
		String address = ExcelUtility.getString(6, 3, "ListDeliveryBoySearchPage");
		String addPassword = ExcelUtility.getString(6, 0, "ListDeliveryBoySearchPage");
		ListDeliveryBoyPage listdeliveryboypage = new ListDeliveryBoyPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		//Login into the application
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		//Navigate to Manage Delivery Boy page or List Delivery Boy page
		dashboardPage.clickManageDeliveryBoy();
		//Insert new delivery boy
		listdeliveryboypage.clickNewButtonInListDeliveryBoy();
		listdeliveryboypage.enterNameInAddDeliveryBoyForm(name);
		listdeliveryboypage.enterEmailInAddDeliveryBoyForm(email);
		listdeliveryboypage.enterPhoneInAddDeliveryBoyForm(phone);
		listdeliveryboypage.enterAddressUnderAddNewDeliveryBoy(address);
		listdeliveryboypage.enterUsernameUnderAddNewDeliveryBoyForm(addUsername);
		listdeliveryboypage.enterPasswordUnderAddNewDeliveryBoyForm(addPassword);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		listdeliveryboypage.clickSaveButtonUnderAddNewDeliveryBoyForm();
		//Verify whether new delivery boy is added successfully
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.enterNameInListDeliveryBoySearchFilter(name);
		listdeliveryboypage.enterEmailInListDeliveryBoySearchFilter(email);
		listdeliveryboypage.enterPhoneInListDeliveryBoySearchFilter(phone);
		listdeliveryboypage.clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter();
		String username1 =listdeliveryboypage.userNameListAfterAddingNewDeliveryBoy();
		assertEquals(username1,addUsername,"Unable to insert new delivery boy");
		
		listdeliveryboypage.deleteDeliveryBoyFromList();
		driver.switchTo().alert().accept();

		
		}
	
	@Test(description="Verify whether user is able to delete new delivery boy")
	public void verifyUserIsAbletoDeleteNewDeliveryBoy() {
		String usernameValue = ExcelUtility.getString(10, 4, "ListDeliveryBoySearchPage");
		String passwordValue = ExcelUtility.getString(10, 5, "ListDeliveryBoySearchPage");
		String name = ExcelUtility.getString(10, 0, "ListDeliveryBoySearchPage");
		String email = ExcelUtility.getString(10, 1, "ListDeliveryBoySearchPage");
		String phone = ExcelUtility.getString(10, 2, "ListDeliveryBoySearchPage");
		String addUsername = ExcelUtility.getString(10, 0, "ListDeliveryBoySearchPage");
		String address = ExcelUtility.getString(10, 3, "ListDeliveryBoySearchPage");
		String addPassword = ExcelUtility.getString(10, 0, "ListDeliveryBoySearchPage");
		ListDeliveryBoyPage listdeliveryboypage = new ListDeliveryBoyPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		//Login into the application
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		//Navigate to Manage Delivery Boy page or List Delivery Boy page
		dashboardPage.clickManageDeliveryBoy();
		//Insert new delivery boy
		listdeliveryboypage.clickNewButtonInListDeliveryBoy();
		listdeliveryboypage.enterNameInAddDeliveryBoyForm(name);
		listdeliveryboypage.enterEmailInAddDeliveryBoyForm(email);
		listdeliveryboypage.enterPhoneInAddDeliveryBoyForm(phone);
		listdeliveryboypage.enterAddressUnderAddNewDeliveryBoy(address);
		listdeliveryboypage.enterUsernameUnderAddNewDeliveryBoyForm(addUsername);
		listdeliveryboypage.enterPasswordUnderAddNewDeliveryBoyForm(addPassword);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		listdeliveryboypage.clickSaveButtonUnderAddNewDeliveryBoyForm();
		//Verify whether new delivery boy is added successfully
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.enterNameInListDeliveryBoySearchFilter(name);
		listdeliveryboypage.enterEmailInListDeliveryBoySearchFilter(email);
		listdeliveryboypage.enterPhoneInListDeliveryBoySearchFilter(phone);
		listdeliveryboypage.clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter();
		listdeliveryboypage.deleteDeliveryBoyFromList();
		driver.switchTo().alert().accept();
		boolean deletionMessage = listdeliveryboypage.verifyUserCreationSuccessMessage();
		assertTrue(deletionMessage,"Failed to delete delivery boy");
	}
	@Test(description="Verify whether reset button clears the search window in list delivery boy page")
	public void verifyResetButtonClearsSearchWindow() {
		
		ListDeliveryBoyPage listdeliveryboypage = new ListDeliveryBoyPage(driver);
		String usernameValue = ExcelUtility.getString(2, 3, "ListDeliveryBoySearchPage");
		String passwordValue = ExcelUtility.getString(2, 4, "ListDeliveryBoySearchPage");
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		dashboardPage.clickManageDeliveryBoy();
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.resetSearchWindowInDeliveryBoyList();
		
		boolean searchWindow = listdeliveryboypage.verifySearchWindowIsResetted();
		assertFalse(searchWindow,"The search window reset failed");

		
	}
	@Test(description = "Verify whether on expanding password accurate data is getting displayed in list delivery boy page")
	public void verifyPasswordFieldIsDisplayingCorrectData() {
		
		String name = ExcelUtility.getString(2, 0, "ListDeliveryBoySearchPage");
		String email = ExcelUtility.getString(2, 1, "ListDeliveryBoySearchPage");
		String phone = ExcelUtility.getString(2, 2, "ListDeliveryBoySearchPage");
		ListDeliveryBoyPage listdeliveryboypage = new ListDeliveryBoyPage(driver);
		String usernameValue = ExcelUtility.getString(2, 3, "ListDeliveryBoySearchPage");
		String passwordValue = ExcelUtility.getString(2, 4, "ListDeliveryBoySearchPage");
		String expectedPassword = ExcelUtility.getString(2, 5, "ListDeliveryBoySearchPage");
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		dashboardPage.clickManageDeliveryBoy();
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.enterNameInListDeliveryBoySearchFilter(name);
		listdeliveryboypage.enterEmailInListDeliveryBoySearchFilter(email);
		listdeliveryboypage.enterPhoneInListDeliveryBoySearchFilter(phone);
		listdeliveryboypage.clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter();
		listdeliveryboypage.clickPasswordExpandingArrow();
		
		String passwordDisplayed = listdeliveryboypage.sendPasswordFromListDeliveryBoy();
		assertEquals(passwordDisplayed, expectedPassword,"Password displayed in the list delivery boy page is incorrect");
	}
	
	@Test(description = "Verify by inactivating delivery boy from List Delivery Boy page")
	public void verifyByInactivatingDeliveryBoy() {
		
		String name = ExcelUtility.getString(2, 0, "ListDeliveryBoySearchPage");
		String email = ExcelUtility.getString(2, 1, "ListDeliveryBoySearchPage");
		String phone = ExcelUtility.getString(2, 2, "ListDeliveryBoySearchPage");
		ListDeliveryBoyPage listdeliveryboypage = new ListDeliveryBoyPage(driver);
		String usernameValue = ExcelUtility.getString(2, 3, "ListDeliveryBoySearchPage");
		String passwordValue = ExcelUtility.getString(2, 4, "ListDeliveryBoySearchPage");
		DashboardPage dashboardPage = new DashboardPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.clickOnSignInButton();
		dashboardPage.clickManageDeliveryBoy();
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.enterNameInListDeliveryBoySearchFilter(name);
		listdeliveryboypage.enterEmailInListDeliveryBoySearchFilter(email);
		listdeliveryboypage.enterPhoneInListDeliveryBoySearchFilter(phone);
		listdeliveryboypage.clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter();
		listdeliveryboypage.clickActivateButton();
		listdeliveryboypage.clickSearchFilter();
		listdeliveryboypage.enterNameInListDeliveryBoySearchFilter(name);
		listdeliveryboypage.enterEmailInListDeliveryBoySearchFilter(email);
		listdeliveryboypage.enterPhoneInListDeliveryBoySearchFilter(phone);
		listdeliveryboypage.clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter();
		
		boolean inactiveButtonAvailable = listdeliveryboypage.verifyInactiveButton();
		assertTrue(inactiveButtonAvailable,"Failed to inactivate user");
		
		listdeliveryboypage.clickinActivateButton();
	}

}
