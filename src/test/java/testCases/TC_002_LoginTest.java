package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test (groups= {"Sanity","Master"})
	public void test_login() throws InterruptedException
	{
	try
	{
	logger.info("******** Starting TC_002_LoginTest*********");
	HomePage hp=new HomePage(driver);
	
	hp.clickMyAccount();
	logger.info("Clicked on My Account ");
	
	hp.clickLogin();
	logger.info("Clicked on Login Link  ");
	
	LoginPage lp=new LoginPage(driver);
	logger.info("Providing Login Details.....  ");
	
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	lp.clickLogin();
	logger.info(" Clicked on Login button  ");
	
	MyAccountPage map=new MyAccountPage(driver);
	logger.info(" Finding out weather my account page exists ");
	
	boolean targetPage=map.isMyAccountPageExist();
	Assert.assertEquals(targetPage, true, "Login Test Failed....");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("*********Finished TC_002_LoginTest***********");
	
	
	
	}
}
