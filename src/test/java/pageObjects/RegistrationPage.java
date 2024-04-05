package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstNameText;
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement lastNameText;
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement eMailText;
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telephoneText;
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement passwordText;
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement passwordConfirmText;
	@FindBy(xpath="//label[normalize-space()='Yes']") 
	WebElement newsletterYesBtn;
	@FindBy(xpath="//input[@value='0']") 
	WebElement newsletterNoBtn;
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeBtn;
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement continueBtn;
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccountDD;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") 
	WebElement registerLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	WebElement loginLink;
	@FindBy(xpath="//img[@title='Your Store']") 
	WebElement logo;
	
	// Actions
	public void setFirstName(String firstNameText) {
		this.firstNameText.sendKeys(firstNameText);
	}
	public void setLastName(String lastNameText) {
		this.lastNameText.sendKeys(lastNameText);
	}
	public void setEMailAddress(String eMailText) {
		this.eMailText.sendKeys(eMailText);
	}
	public void setTelephone(String telephoneText) {
		this.telephoneText.sendKeys(telephoneText);
	}
	public void setPassword(String passwordText) {
		this.passwordText.sendKeys(passwordText);
	}
	public void setConfirmPassword(String passwordConfirmText) {
		this.passwordConfirmText.sendKeys(passwordConfirmText);
	}
	public void clickNewsLetterYes() {
		newsletterYesBtn.click();
	}
	public void clickNewsLetterNo() {
		newsletterNoBtn.click();
	}
	public void clickAgree() {
		agreeBtn.click();
	}
	public void clickContinue() {
		continueBtn.click();
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
	
	

}
