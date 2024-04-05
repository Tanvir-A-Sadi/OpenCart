package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators

	@FindBy(xpath="//input[@id='input-password']") 
	WebElement passwordInput;
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement eMailAddressInput;
	@FindBy(xpath="//input[@value='Login']") 
	WebElement loginBtn;
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccountDD;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") 
	WebElement registerLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	WebElement loginLink;	
	
	// Actions
	public void setEMailAddress(String email) {
		eMailAddressInput.sendKeys(email);
	}
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public void clickContinueBtn() {
		loginBtn.click();
	}
	public void clickMyAccountDD() {
		myAccountDD.click();
	}
	public void clickRegister() {
		registerLink.click();
	}
	public void clickLogin() {
		loginLink.click();
	}
}
