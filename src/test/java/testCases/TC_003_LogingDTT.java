package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC_003_LogingDTT extends BaseClass{

	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_LoginDTT(String email, String password, String result)
	{
		
		logger.info("******** Starting TC_003_LogingDTT*********");
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing Login Details.....  ");
		
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		
		//My Account Page
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExist();
		
		if(result.equals("Valid"))
		{
			if(targetPage==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
	if(result.equals("Invalid"))
	{
		if(targetPage==true)
		{
			map.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
	logger.info("*******Finished TC_003_LoginDDT************* ");
	
	
	
	
	
	}	
	
}
