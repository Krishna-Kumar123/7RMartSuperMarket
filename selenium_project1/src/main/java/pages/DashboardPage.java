package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'deliveryboy') and @class='small-box-footer']") WebElement manageDeliveryBoy;
	@FindBy(xpath="//h1[contains(text(),'List Delivery Boy')]") WebElement listDeliveryBoy;
	
	public void clickManageDeliveryBoy() {
		
		manageDeliveryBoy.click();
	}
	
	public boolean isManageDeliveryBoyPageLoaded() {
		
		return listDeliveryBoy.isDisplayed();
		
		
	}

}
