package com.qa.Opencart.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtil;

public class SearchPage {
	public WebDriver driver;
	public ElementUtil eleutil;
 private By Productcount= By.cssSelector("div h4");
 
 
	public SearchPage(WebDriver driver)
	{
		this.driver= driver;
		eleutil= new ElementUtil(driver);
	}
	// method for finding no of products
	public int Productcount()
	{
	int productlist=	eleutil.getElements(Productcount).size();
	return productlist;
	}
	//  click on a product
	public  ProductinfoPage Clickonproduct( String productname)
	{  By productnamelocator= By.linkText(productname);
		eleutil.doClick(productnamelocator);
		return  new ProductinfoPage(driver);
	}

	
	
	
}
