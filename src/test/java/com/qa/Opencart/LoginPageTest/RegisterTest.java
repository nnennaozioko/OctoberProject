package com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.BaseTest.BasePageTest;
import com.qa.Opencart.Utils.ExcelUtil;

public class RegisterTest extends BasePageTest{
// Register page setup
	@BeforeClass
	public void RegisterPageSetUp()
	{
	Register=	login.DoclickRegisterlink();//Build pattern
	}
	@DataProvider
	public Object[][] getTestData()
	{
	Object[][] regtestdata=	ExcelUtil.getTestData("Register");
	return regtestdata;
	}
	@Test(dataProvider="getTestData")
	public void VerifyRegtest(String FirstName, String LastName, String Email, String Telephone, String Password, String Subscribe)
	{
		Register.RegisterUser(FirstName, LastName, Email, Telephone, Password, Subscribe);
		Assert.assertTrue(Register.navigateToRegisterlink());


}
}
