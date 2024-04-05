package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClassOpencart;
import pageObjects.AccountCreationPage;
import pageObjects.HomePage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;

public class TC_001_AccountRegistration extends BaseClassOpencart{
	
	@Test(groups = {"master", "sanity"})
	public void verifyAccountRegistration() {
		try {
			logger.info("********** Starting TC_001_AccountRegistration ************");
			logger.info("********** Loading Homepage ************");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccountDD();
			hp.clickRegisterLink();
			logger.info("********** Clicked register from homepage ************");
			
			logger.info("********** Loading registration page ************");
			logger.info("********** Setting up inputs ************");
			RegistrationPage rp = new RegistrationPage(driver);
			rp.setFirstName(generateRandomAlphabetic(6));
			rp.setLastName(generateRandomAlphabetic(5));
			rp.setEMailAddress(generateRandomEmail(generateRandomAlphabetic(5)));
			rp.setTelephone(generateRandomNumeric(10));
			String passwordString = generateRandomAlphaNumeric(8);
			rp.setPassword(passwordString);
			rp.setConfirmPassword(passwordString);
			rp.clickNewsLetterYes();
			rp.clickAgree();
			rp.clickContinue();
			logger.info("********** Done setting up inputs and clicked Continue ************");
			
			AccountCreationPage acp = new AccountCreationPage(driver);
			logger.info("********** Verifying Account Creation ************");
			Assert.assertTrue(acp.verifyAccountCreationStatus());
			acp.clickContinueBtn();
			logger.info("********** Clicked Continue ************");
			
			logger.info("********** Loading MyAccount Page ************");
			MyAccountPage map = new MyAccountPage(driver);
			Assert.assertTrue(map.verifyMyAccount());
			map.clickMyAccountDD();
			map.clickLogoutLink();
			logger.info("********** Clicked logout link ************");
			
			LogoutPage lop = new LogoutPage(driver);
			Assert.assertTrue(lop.verifyLogoutStatus());
			lop.clickContinueBtn();
			logger.info("********** Clicked continue from logout page ************");
			
			logger.info("********** Verifying Homepage ************");
			Assert.assertTrue(hp.verifyHomepage());
			logger.info("********** Ended TC_001_AccountRegistration ************");
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
