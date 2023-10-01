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
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		eleutil= new ElementUtil(driver);
	}
	//Page Actions
	
	public void RegisterUser(String FirstName, String LastName, String Email, String Telephone, String Password, String Subscribe)
	{
		
	}
}
