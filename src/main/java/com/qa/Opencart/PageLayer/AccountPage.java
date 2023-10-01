package com.qa.Opencart.PageLayer;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtil;

public class AccountPage {

	public  WebDriver driver;
	public ElementUtil eleutil;
	
	private By myaccountlink= By.linkText("My Account");
	private By editaccountlink= By.linkText("Edit Account");
	private By passwordlink= By.linkText("Password");
	private By searchbar= By.name("search");
	private By AccountHeaders= By.cssSelector("div#content h2");//1 of 4
	private By SearchBar= By.xpath("//input[@name='search']");
	private By searchicon= By.xpath("//span//button[@type='button']");
	//Constructor
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		eleutil= new ElementUtil(driver);
	}
	// locators, page actions: methods
	//1.Verify MyAccount link is displayed
	public boolean myAccountLinkDisplayed()
	{
	//creating webelement
	return	 eleutil.doElementIsDisplayed(myaccountlink);
			//driver.findElement(myaccountlink).isDisplayed();
	}
	
//2. verify EditAccount link is displayed
	public boolean editAccountLink()
	{
	return	eleutil.doElementIsDisplayed(editaccountlink);
			//driver.findElement(editaccountlink).isDisplayed();
	
	}
	//3. verify password link is displayed
	public boolean passwordLinkExist() {
	return	eleutil.doElementIsDisplayed(passwordlink);
			//driver.findElement(passwordlink).isEnabled();
	}
	//4. verify Searchbar is displayed
	public boolean serachBarDisplayed()
	{
	return	eleutil.doElementIsDisplayed(searchbar);//true or false
	}
	// verify Account Headers are correct or not
	
	public ArrayList<String> AccountHeaderslist()
	{
		//Collection: ArrayList
List<WebElement>	AccountHeaderlist=	driver.findElements(AccountHeaders);
ArrayList<String> ArrayAccountlist= new ArrayList<String>();

for(WebElement e: AccountHeaderlist )//1,2,3,4
{
 String text=	e.getText();
 
		ArrayAccountlist.add(text);
	}

return ArrayAccountlist;
}
public SearchPage DoSearch( String searchkey)	//imac, MacBook, Apple
{ eleutil.getElement(SearchBar).clear();//it will clear data from search bar
	eleutil.getElement(SearchBar).sendKeys(searchkey);//imac
	eleutil.clickWhenReady(10, searchicon);
return	new SearchPage(driver);//Test Driven Development approach
	
}
}
