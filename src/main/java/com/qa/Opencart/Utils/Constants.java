package com.qa.Opencart.Utils;

import java.util.ArrayList;

public class Constants {
	//methods and variables should be static final
	//application level
	public final static String logintitle="Account Login";
	public final static String Url="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static final ArrayList<String> AccountHeaderExpectedValues()
	{
		ArrayList<String> accountlist= new ArrayList<String>();
		accountlist.add("My Account");
		accountlist.add("My Orders");
		accountlist.add("My Affiliate Account");
		accountlist.add("Newsletter");
		
		return accountlist;
		
	}
	
	
}
