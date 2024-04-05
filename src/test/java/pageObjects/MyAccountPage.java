package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement myAccountText;
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccountDD;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']") 
	WebElement myAccountLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Order History']") 
	WebElement orderHistoryLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Transactions']") 
	WebElement transactionsLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Downloads']") 
	WebElement downloadsLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") 
	WebElement logoutLink;
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-shopping-cart']") 
	WebElement cartIconBtn;
	
	// Actions
	public boolean verifyMyAccount() {
		try {
			return myAccountText.getText().equalsIgnoreCase("My Account");
		} catch (Exception e) {
			return false;
		}
	}
	public void clickMyAccountDD() {
		myAccountDD.click();
	}
	public void clickMyAccountLink() {
		myAccountLink.click();
	}
	public void clickOrderHistoryLink() {
		orderHistoryLink.click();
	}
	public void clickTransactionsLink() {
		transactionsLink.click();
	}
	public void clickDownloads() {
		downloadsLink.click();
	}
	public void clickLogoutLink() {
		logoutLink.click();
	}
	public void clickCartIconBtn() {
		cartIconBtn.click();
	}
}
