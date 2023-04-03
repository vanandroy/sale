package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	//DataBase Connection
	@BeforeSuite
	public void configBeforeSuite() throws Throwable {
		dLib.connectToDb();
		System.out.println("--connect to DB--");
		Reporter.log("configBeforeSuite",true);
	}
	//Opening The Browser
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"regression","smoke"})
	//public void configBeforeClass(String BROWSER) throws Throwable {
	public void configBeforeClass() throws Throwable {
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		Reporter.log("configBeforeClass",true);
		
	}
	//Entering the URL(Login the Application)
	@BeforeMethod(groups = {"regression","smoke"})
	public void configBeforeMethod() throws Throwable {
		String URL=fLib.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("configBeforeMethod",true);
	}
	//(Logout the Application)
	@AfterMethod
	public void configAfterMethod() {
		Reporter.log("configAfterMethod",true);
	}
	//Closing All Browser
	@AfterClass(groups = {"regression","smoke"})
	public void configAfterClass() {
		driver.quit();
		Reporter.log("configAfterClass",true);
	}
	//Closing DataBase Connection
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		dLib.closeDB();
		Reporter.log("configAfterSuite",true);
	}

}
