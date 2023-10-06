package com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Opencart.BaseTest.BasePageTest;
import com.qa.Opencart.Utils.Constants;

public class LoginpageTest extends BasePageTest{
	//LoginPageTest is a child
	// Setup method
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{// Unit tests
	// Assertions: To verify actual value vs expected value
		Assert.assertEquals(login.getLoginPageTitle(), Constants.logintitle);
		
		
	}
	@Test(priority=2)
	public void verifyCurrentUrl()
	{
		//Validate currenturl 
		Assert.assertEquals(login.getUrl(),Constants.Url);
	}
	@Test(priority=3)
	public void verifyforgotpasswordlinkdisplayed()
	{
		Assert.assertTrue(login.forgotpasswordLinkDisplay());
	}

}
