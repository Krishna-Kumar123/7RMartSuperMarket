package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;


public class ListDeliveryBoyPage {
	
	WebDriver driver;
	PageUtility pageUtility;
	WaitUtility waitUtility;
	
	public ListDeliveryBoyPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		pageUtility = new PageUtility();
		waitUtility = new WaitUtility();
	}
	
	@FindBy(xpath="//*[contains(text(),'Search') and @class='btn btn-rounded btn-primary']") WebElement searchFilter;
	@FindBy(xpath="//*[contains(text(),'Search List Delivery Boy')]") WebElement searchListDeliveryBoy;
	@FindBy(xpath="//input[@id='un']") WebElement nameField;
	@FindBy(xpath="//input[@id='ut']") WebElement emailField;
	@FindBy(xpath="//input[@id='ph']") WebElement phoneField; 
	@FindBy(xpath="//button[@name='Search']") WebElement searchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement nameResult;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]") WebElement emailResult;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]") WebElement phoneResult;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement creationSuccessMessage;
	@FindBy(xpath ="//input[@id='name']") WebElement nameUnderAddNewDeliveryBoy;
	@FindBy(xpath ="//input[@id='email']") WebElement emailUnderAddNewDeliveryBoy;
	@FindBy(xpath ="//input[@id='phone']") WebElement phoneUnderAddNewDeliveryBoy;
	@FindBy(xpath ="//textarea[@id='address']") WebElement addressUnderAddNewDeliveryBoy;
	@FindBy(xpath ="//input[@id='username']") WebElement usernameUnderAddNewDeliveryBoy;
	@FindBy(xpath ="//input[@id='password']") WebElement passwordUnderAddNewDeliveryBoy; 
	@FindBy(xpath ="//button[@class='btn btn-danger']") WebElement saveButtonUnderAddNewDeliveryBoy;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newButtonAddNewDeliveryBoy;
	@FindBy(xpath="//h1[text()='Add-Delivery Boy']") WebElement addDeliveryBoyForm;
	@FindBy(xpath="//table//tr//td[5]") WebElement usernameList;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") WebElement deliveryboyDeleteButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement deliveryboyResetButton;
	@FindBy(xpath="//h4[text()='Search List Delivery Boy']") WebElement deliveryboySearchWindow;
	@FindBy(xpath="//i[@class='fa fa-angle-double-down']") WebElement passwordExpandingArrow;
	@FindBy(xpath="//div[@class='profile-info-name']//span") WebElement passwordData;
	@FindBy(xpath="//span[text()='Active']") WebElement activateButton;
	@FindBy(xpath="//span[text()='Inactive']") WebElement inactivateButton;
	
	//@FindBys({@FindBy(xpath="//table//tr//td[5]")}) public List<WebElement> usernameList;
	
	public void clickSearchFilter() {
		
		searchFilter.click();
	}
	
	public boolean isSearchFilterLoaded() {
		
		return searchListDeliveryBoy.isDisplayed();
	}
	
	public void enterNameInListDeliveryBoySearchFilter(String name ) {
		
		nameField.sendKeys(name);
		
	}
	
	public void enterPhoneInListDeliveryBoySearchFilter(String phone ) {
		
		phoneField.sendKeys(phone);
		
	}
	
	public void enterEmailInListDeliveryBoySearchFilter(String email ) {
		
		emailField.sendKeys(email);
		
	}
	
	public void clickSearchButtonOfSearchFilterInListDeliveryBoySearchFilter() {
		
		searchButton.click();;
		
	}
	public String verifyNameLoaded() {
		return nameResult.getText();
	
	}
	
	public String verifyEmailLoaded() {
		return emailResult.getText();
	
	}
	public String verifyPhoneLoaded() {
		return phoneResult.getText();
	
	}
	
	public boolean verifyUserCreationSuccessMessage() {
		return creationSuccessMessage.isDisplayed();
	}
	
	public void clickNewButtonInListDeliveryBoy() {
		
		newButtonAddNewDeliveryBoy.click();;
		
	}
	
	public boolean verifyAddDeliveryBoyFormIsDisplayed() {
		return addDeliveryBoyForm.isDisplayed();
	}
	
	public void enterNameInAddDeliveryBoyForm(String name ) {
		
		nameUnderAddNewDeliveryBoy.sendKeys(name);
		
	}
	public void enterEmailInAddDeliveryBoyForm(String email ) {
		
		emailUnderAddNewDeliveryBoy.sendKeys(email);
		
	}
	
	public void enterPhoneInAddDeliveryBoyForm(String phone ) {
		
		phoneUnderAddNewDeliveryBoy.sendKeys(phone);
		
	}
	public void enterAddressUnderAddNewDeliveryBoy(String address ) {
		
		addressUnderAddNewDeliveryBoy.sendKeys(address);
		
	}
	public void enterUsernameUnderAddNewDeliveryBoyForm(String username ) {
		
		usernameUnderAddNewDeliveryBoy.sendKeys(username);
		
	}
	public void enterPasswordUnderAddNewDeliveryBoyForm(String password ) {
		
		passwordUnderAddNewDeliveryBoy.sendKeys(password);
		
	}
	
	public void clickSaveButtonUnderAddNewDeliveryBoyForm() {
		
		waitUtility.waitForElement(driver,saveButtonUnderAddNewDeliveryBoy);
		pageUtility.elementClick(driver,saveButtonUnderAddNewDeliveryBoy);
	}
	public String userNameListAfterAddingNewDeliveryBoy() {
		
		
		return usernameList.getText();
		
	}
	public void deleteDeliveryBoyFromList() {
	
		pageUtility.elementClick(driver,deliveryboyDeleteButton);
		
	}
	
	public void resetSearchWindowInDeliveryBoyList() {
		
		pageUtility.elementClick(driver,deliveryboyResetButton);		
	}
	
	public boolean verifySearchWindowIsResetted() {
		return deliveryboySearchWindow.isDisplayed();
	}
	
	public void clickPasswordExpandingArrow() {
		
		pageUtility.elementClick(driver,passwordExpandingArrow);
		
	}
	
	public String sendPasswordFromListDeliveryBoy() {
		return passwordData.getText();
	}
	public void clickActivateButton() {
		
		pageUtility.elementClick(driver,activateButton);	
		
	}
	public boolean verifyInactiveButton() {
		
		return inactivateButton.isDisplayed();
		
	}
	public void clickinActivateButton() {
		
		pageUtility.elementClick(driver,inactivateButton);	
	}
	
	
}
