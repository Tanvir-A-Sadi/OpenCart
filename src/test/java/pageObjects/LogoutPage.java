package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators

	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccountDD;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") 
	WebElement registerLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	WebElement loginLink;
	@FindBy(xpath="//img[@title='Your Store']") 
	WebElement logo;
	@FindBy(xpath="//a[normalize-space()='Continue']") 
	WebElement continueBtn;
	@FindBy(xpath="//h1[normalize-space()='Account Logout']") 
	WebElement accountLogoutText;
	
	// Actions
	
	public boolean verifyLogoutStatus() {
		try {
			return accountLogoutText.getText().equalsIgnoreCase("Account Logout");
		} catch (Exception e) {
			return false;
		}
	}
	public void clickMyAccountDD() {
		myAccountDD.click();
	}
	public void clickRegisterLink() {
		registerLink.click();
	}
	public void clickLoginLink() {
		loginLink.click();
	}
	public void clickLogo() {
		logo.click();
	}
	public void clickContinueBtn() {
		continueBtn.click();
	}

}
