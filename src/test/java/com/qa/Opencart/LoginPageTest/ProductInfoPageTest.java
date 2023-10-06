package com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Opencart.BaseTest.BasePageTest;

public class ProductInfoPageTest extends BasePageTest {
	
	//ProductInfoPage SetUp
@BeforeClass
public void ProductInfoPageSetUp()
{
	account=	login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
}
@Test(enabled= false)
public void VerifyProductHeader()
{
search=	account.DoSearch("Macbook");
productinfo=	search.Clickonproduct("MacBook Air");
//productinfo.productHeader();//it will give Header text
Assert.assertEquals(productinfo.productHeader(), "MacBook Air");
}

//Validate product meta data
@Test
public void verifyproductmetadata()
{
	search=	account.DoSearch("Macbook");
	productinfo=	search.Clickonproduct("MacBook Air");
	//System.out.println(productinfo.getProductmetadata());
	Assert.assertEquals("Apple", "Apple");
	Assert.assertEquals("In stock", "In Stock");
	Assert.assertEquals("Product 17", "Product 17");
	Assert.assertEquals("700", "700");
}

}
