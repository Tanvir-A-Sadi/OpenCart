package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClassOpencart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClassOpencart{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"master", "sanity"})
	public void verify_LoginDDT(String email, String password, String status) {
		logger.info("************ Starting TC_003_LoginDDT **************");
		logger.info("************ Loading Homepage **************");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccountDD();
		hp.clickLoginLink();
		logger.info("************ Clicked Login from homepage **************");
		
		logger.info("************ Setting up inputs **************");
		LoginPage lip = new LoginPage(driver);
		lip.setEMailAddress(email);
		lip.setPassword(password);
		lip.clickContinueBtn();
		logger.info("************ Clicked on continue **************");
		
		MyAccountPage map = new MyAccountPage(driver);
		logger.info("************ Checking MyAccount status **************");
		boolean pageStatus = map.verifyMyAccount();
		
		if(status.equalsIgnoreCase("Valid")) {
			if(pageStatus == true) {
				map.clickMyAccountDD();
				map.clickLogoutLink();
				Assert.assertTrue(true);
				logger.info("************ Test passed **************");
			}
			else {
				Assert.fail();
				logger.info("************ Test failed **************");
			}
		}
		if(status.equalsIgnoreCase("Invalid")) {
			if(pageStatus == true) {
				map.clickMyAccountDD();
				map.clickLogoutLink();
				Assert.assertTrue(false);
				logger.info("************ Test failed **************");
			}
			else {
				Assert.assertTrue(true);
				logger.info("************ Test passed **************");
			}
		}
	}

}
