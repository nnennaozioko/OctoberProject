package com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.BaseTest.BasePageTest;
import com.qa.Opencart.Utils.Constants;

public class AccountpageTest extends BasePageTest {
	//Unit test cases
	// Setup Account page// login username and password
	@BeforeClass
	public void AccountPageSetUp()
	{
	account=	login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
	}
	
	
	
	@Test(priority=1, enabled= false)
	public void verifyMyAccountDisplayed()//1
	{
		Assert.assertTrue(account.myAccountLinkDisplayed());
	}
	@Test(priority=2, enabled= false)
	public void verifyEditAccountLinkDisplayed()
	{
		Assert.assertTrue(account.editAccountLink());
		
	}
	@Test(priority=3, enabled= false)//3
	public void verifyPasswordlinkDisplayed()
	{
		Assert.assertTrue(account.passwordLinkExist());
	}
	@Test(priority=4, enabled= false)//4
	public void verifySearchBar()//4
	{
		Assert.assertTrue(account.serachBarDisplayed());
	}
@Test(priority=5, enabled= false)
public void verifyAccountHeaders()
{
//actual value vs expected value
	Assert.assertEquals(account.AccountHeaderslist(),Constants.AccountHeaderExpectedValues());
}
// DataProvider
//data driven testing
@DataProvider
public Object[][] getsearchData()
{
	return new Object[][] {
		{"Apple",1},
		{"Macbook",3},
		{"imac", 1}
			
			
			
	};
	}

@Test(priority=6 ,dataProvider="getsearchData", enabled= false)
public void verifyProductCount(String searchkey, int productcount)
{
	search=account.DoSearch(searchkey);
	Assert.assertEquals(search.Productcount(), productcount);
	
}
/**
 * Macbook,MacBook, 5
Macbook, MacBook Air,4
Macbook, MacBook Pro, 4
Apple,Apple Cinema 30",6
Samsung, Samsung SyncMaster 941BW,1
samsung, Samsung SyncMaster 941BW, 7
 */

@DataProvider
public Object[][] getProductTestData()
{
	return new Object[][]
			{
		{ "Macbook","MacBook", 5},
		{"Macbook", "MacBook Air",4},
		{"Macbook", "MacBook Pro", 4},
		{"Apple","Apple Cinema 30\"",6},
		{"Samsung", "Samsung SyncMaster 941BW",1},
		{"Samsung", "Samsung Galaxy Tab 10.1", 7}
			};
}
// Validate product image count
@Test( priority=7, dataProvider="getProductTestData")
public void VerifyProductData(String searchkey, String productname, int imagecount)
{
search=	account.DoSearch(searchkey);// build  pattern
productinfo=search.Clickonproduct(productname);// Product page
Assert.assertEquals(productinfo.productImageCount(), imagecount);

}
}
