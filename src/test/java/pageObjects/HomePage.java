package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Locators

	@FindBy(xpath="//img[@title='Your Store']") 
	WebElement logo;
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccountDD;
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement registerLink;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginLink;
	
	// Actions
	public boolean verifyHomepage() {
		try {
			return logo.getAttribute("title").equalsIgnoreCase("Your Store");
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
	

}
