package testCases;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{

	
	
	@Test(groups={"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
	//	logger.debug("Application Logs....");
		logger.info("**** Starting TC_001_AccountRegistrationTest ****** ");
	try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Data");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		String st = randomString()+"@gmail.com";
		regPage.setEmail(st); //randomly generated the email
		regPage.setPassword(alphaNumeric());
		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(regPage.getPrivacyPolicy());
		Thread.sleep(3000);
		actions.perform();
		Thread.sleep(3000);
		
		regPage.setPrivacyPolicy();
		Thread.sleep(3000);
		regPage.clickContinue();
		Thread.sleep(3000);
		logger.info("Clicked on Continue");
		
		String confmsg=regPage.getConfirmation();
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected message");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			System.out.println(e);
			//Assert.fail();  
		}
		logger.info("***** Finished TC_001_AccountRegistrationTest *******");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
