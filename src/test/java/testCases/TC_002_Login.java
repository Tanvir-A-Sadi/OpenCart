package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClassOpencart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;

public class TC_002_Login extends BaseClassOpencart{
	
	@Test(groups = {"master", "regression"})
	public void verifyAccountLogin() {
		try {
			logger.info("********** Starting TC_002_Login ************");
			logger.info("********** Loading Homepage ************");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccountDD();
			hp.clickLoginLink();
			logger.info("********** Clicked Login ************");
			
			LoginPage lip = new LoginPage(driver);
			logger.info("********** Entering inputs ************");
			lip.setEMailAddress(properties.getProperty("email"));
			lip.setPassword(properties.getProperty("password"));
			lip.clickContinueBtn();
			logger.info("********** Clicked continue ************");
			
			MyAccountPage map = new MyAccountPage(driver);
			logger.info("********** Verifying MyAccount page ************");
			Assert.assertTrue(map.verifyMyAccount());
			map.clickMyAccountDD();
			map.clickLogoutLink();
			logger.info("********** Clicked logout link ************");
			
			LogoutPage lop = new LogoutPage(driver);
			logger.info("********** Verifying LogoutPage ************");
			Assert.assertTrue(lop.verifyLogoutStatus());
			lop.clickContinueBtn();
			logger.info("********** Clicked Continue from logout page ************");
			
			logger.info("********** Verifying homepage ************");
			Assert.assertTrue(hp.verifyHomepage());
			logger.info("********** Ended TC_002_Login ************");
		} catch (Exception e) {
			logger.info("********** TC_001_AccountRegistration Failed ************");
			Assert.fail();
		}
		
	}

}
