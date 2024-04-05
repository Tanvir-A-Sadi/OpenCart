package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends BasePage{
	
	WebDriver driver;
	public AccountCreationPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement accountCreationMessage;
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
	@FindBy(xpath="//a[normalize-space()='Continue']") 
	WebElement continueBtn;	
	
	// Actions
	public boolean verifyAccountCreationStatus() {
		try {
			return accountCreationMessage.getText().equalsIgnoreCase("Your Account Has Been Created!");
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
	public void clickTransactionLink() {
		transactionsLink.click();
	}
	public void clickDownloadsLink() {
		downloadsLink.click();
	}
	public void clickLogoutLink() {
		logoutLink.click();
	}
	public void clickContinueBtn() {
		continueBtn.click();
	}

}
