package com.qa.Opencart.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtil;

public class RegisterPage {
 public WebDriver driver;
 public ElementUtil eleutil;
 private By FN= By.name("firstname");
 private By LN= By.name("lastname");
 private By Mail= By.name("email");
 private By tele= By.name("telephone");
 private By pwd= By.name("password");
 private By confirmpwd= By.name("confirm");
 private By Subscribeyes= By.xpath("//label[normalize-space()='Yes']//input[@type='radio']");
 private By SubscribeNo=By.xpath("//label[normalize-space()='No']//input[@type='radio']");
 private By Checkbox= By.xpath("//input[@type='checkbox']");
 private By Continuebtn= By.xpath("//input[@type='submit']");
 private By successm= By.cssSelector("div#content h1");
 private By logoutlink=By.linkText("Logout");
 private By Registerlink= By.linkText("Register");
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		eleutil= new ElementUtil(driver);
	}
	//Page Actions
	
	public void RegisterUser(String FirstName, String LastName, String Email, String Telephone, String Password, String Subscribe)
	{
		eleutil.doSendKeys(FN, FirstName);
		eleutil.doSendKeys(LN, LastName);
		eleutil.doSendKeys(Mail, Email);
		eleutil.doSendKeys(tele, Telephone);
		eleutil.doSendKeys(pwd, Password);
		eleutil.doSendKeys(confirmpwd, Password);
		if(Subscribe.equalsIgnoreCase("Yes"))
		{
			eleutil.doClick(Subscribeyes);
		}
		else
		{
			eleutil.doClick(SubscribeNo);
		}
		eleutil.doClick(Checkbox);
		eleutil.doClick(Continuebtn);
		
	}
	public boolean navigateToRegisterlink()
	{
		String message="Your Account Has Been Created";
		String text=eleutil.getElement(successm).getText();
		System.out.println(text);
		if(text.contains(message))
		{
			eleutil.doClick(logoutlink);
			eleutil.doClick(Registerlink);
			return true;
		}
		return false;
	}
	
}
