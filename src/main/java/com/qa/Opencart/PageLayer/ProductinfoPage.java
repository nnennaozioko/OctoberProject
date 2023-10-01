package com.qa.Opencart.PageLayer;


import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtil;

public class ProductinfoPage {
	public WebDriver driver;
	public ElementUtil eleutil;
	private By productimages= By.cssSelector("ul.thumbnails li img");
	private By productHeader= By.cssSelector("div h1");
	private By productmeadata= By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]//li");//4

	HashMap<String,String> map= new HashMap<String, String>();
	public ProductinfoPage(WebDriver driver)
	{
		this.driver= driver;
		eleutil= new ElementUtil(driver);
	}
	// imagecount
	public int productImageCount()
	{
	int imagecount=	eleutil.getElements(productimages).size();
	return imagecount;
	}
	// Product Header method
	public String productHeader()
	{
	String	text=eleutil.getElement(productHeader).getText();
	System.out.println(text);
	return text;
}
	// method for productmetadata
	public HashMap<String,String> getProductmetadata()
	{
	List<WebElement> productmetadatalist=	eleutil.getElements(productmeadata);
	for(WebElement e: productmetadatalist)
	{
	String meta=	e.getText();
String[] metadata=	meta.split(":");
String key= metadata[0];// Brand
String Value= metadata[1];//Apple
map.put(key, Value);
	
	}
	return map;
	}
	
}
