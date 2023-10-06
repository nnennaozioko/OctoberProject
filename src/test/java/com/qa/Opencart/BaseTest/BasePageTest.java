package com.qa.Opencart.BaseTest;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.Opencart.DriveFactory.Driverfactory;
import com.qa.Opencart.PageLayer.AccountPage;
import com.qa.Opencart.PageLayer.Loginpage;
import com.qa.Opencart.PageLayer.ProductinfoPage;
import com.qa.Opencart.PageLayer.RegisterPage;
import com.qa.Opencart.PageLayer.SearchPage;

public class BasePageTest {// parent class
	// Setup method
	//TearDown method
	
// Setup method:TestNG methods
	//1. Before Suite 2. Before Test 3. Before class 4. Before Method
	// @Test// run// Assertion
	//TearDown:Before Method, Before class, Before Test, Before Suite
	
	 
	 WebDriver driver;
	 public Properties prop;
	  Driverfactory df1;
	
	public Loginpage login;	
public 	AccountPage account;
public SearchPage search;
public ProductinfoPage productinfo;
public RegisterPage Register;
	 
	@BeforeTest
	public void SetUp()
	{
	 df1= new Driverfactory();

	 prop=df1.initProperties();
	 driver= df1.InitialiseDriver(prop);
	 login= new Loginpage(driver);
	
 
	}
	
	@AfterTest
	public void TearDown()
	{
		//driver.quit();// closing browser
	}

}
