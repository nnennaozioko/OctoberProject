package com.qa.Opencart.PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Opencart.Utils.ElementUtil;

public class Loginpage {
	//Loginpage actions
// Constructor
	//By creating object and by using object reference variable we can call methods
	
	
	public WebDriver driver;
	// By Using object reference variable , we can call all methods from one class to another class
	public ElementUtil eleutil;
	
	//Encapsulation//null
	private By mailid= By.name("email");
	private By pass= By.id("input-password");
 private By loginbutton= By.xpath("//input[@type='submit']");
 private By Forgottenpasswordlink= By.partialLinkText("Forgotten Password");
 private By Registerlink=By.linkText("Register");
 
//Constructor creation
	public Loginpage(WebDriver driver)
	{
		this.driver= driver;
		eleutil= new ElementUtil(driver);
	}
	//page actions
	// Page title
	public String getLoginPageTitle()
	{
	return driver.getTitle();//page title//Account Login
	
	}
	//Current url
	public String getUrl()
	{
		//void does not give return
	String URL=	driver.getCurrentUrl();
	return URL;
	}
	// Verify passwordlink is displayed
	public boolean forgotpasswordLinkDisplay()
	{
	boolean forgotlink	= eleutil.doElementIsDisplayed(Forgottenpasswordlink);
			//driver.findElement(Forgottenpasswordlink).isDisplayed();
	return forgotlink;
	}
	// Doclick Registerlink method
	public RegisterPage DoclickRegisterlink()
	{
		eleutil.doClick(Registerlink);
		return new RegisterPage(driver);
		
	}
	
	// Login with username and password
	public AccountPage doLogin(String username, String password)
	{
		//driver.findElement(mailid).sendKeys(username);
		eleutil.doSendKeys(mailid, username);
		//driver.findElement(pass).sendKeys(password);
		eleutil.doSendKeys(pass, password);
		//driver.findElement(loginbutton).click();
		eleutil.doClick(loginbutton);
		return new AccountPage(driver);//object// page chaining model
		//TDD (Test Driven Development)approach:write some code and implement the code based on the requirement.
		
	}
	
}
