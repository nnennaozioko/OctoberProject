package com.qa.Opencart.DriveFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.Opencart.Utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
// Public -access modifier
	// you can use this class anywhere in the project
	//Initialise driver method
	public WebDriver driver;
	public Properties prop;
	public OptionsManager op;
	public static String highlight; 
	// We call methods by using object reference variable
	public WebDriver InitialiseDriver(Properties prop)
	{    op= new OptionsManager(prop);
	highlight= prop.getProperty("highlight");
		// browser is coming from config file
	String browsername=	prop.getProperty("browser");//chrome
		System.out.println("the browser is :"+ browsername);
		//   chrome//chrome
		if(browsername.trim().equalsIgnoreCase("chrome"))
		{
//		//chrome driver
//					WebDriverManager.chromedriver().setup();// it will setup chromedriver
//					//Object
//					 // creating ChromeDriver object
//	    
//				driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(op.getChromeOptions());
			
		}
		else if(browsername.trim().equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();// object creation
			//top costing
		}
		else if(browsername.trim().equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
			
		}
		else if(browsername.trim().equalsIgnoreCase("edge"))
		{WebDriverManager.edgedriver().setup();
		EdgeOptions options= new EdgeOptions();
		options.addArguments("--start-maximized");
		driver= new EdgeDriver(options);
			
		}
		else
		{
			System.out.println("enter the correct browser name:");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	/**
	 * Create a method for getting properties from config file
	 * Properties class methods
	 * 
	 */
	public Properties initProperties()
	{
		prop= new Properties();// object creation
		
		try {
			// initialised file
			FileInputStream ip= new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\NellyAndLakshmiProject\\src\\test\\resources\\ConfigFile");
			
			prop.load(ip);// loading files
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;// property file
	}
	
}
