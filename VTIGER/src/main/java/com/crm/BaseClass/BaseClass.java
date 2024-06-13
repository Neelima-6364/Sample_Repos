package com.crm.BaseClass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.crm.generic.databaseutility.DataBaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassobject;
import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;

	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebdriverUtility wLib=new WebdriverUtility();

	//For Cross Browser execution
	//@Parameters("BROWSER") and
	//pass String browser parameter in side beforeclass()

	@BeforeSuite
	public void beforesuite() throws SQLException
	{
		dLib.getDBConnection();

	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void beforeclass(/*String browser*/) throws IOException
	{
		String browser=System.getProperty("Browser",fLib.getDataFromPropertiesFile("Browser"));
		//String browser =fLib.getDataFromPropertiesFile("Browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//sdriver=driver;
		UtilityClassobject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void beforeMethod() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String URL=System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		String un=System.getProperty("Username",fLib.getDataFromPropertiesFile("UserName"));
		String ps=System.getProperty("Password",fLib.getDataFromPropertiesFile("Password"));
//		String URL=fLib.getDataFromPropertiesFile("url");
//		String un =fLib.getDataFromPropertiesFile("UserName");
//		String ps =fLib.getDataFromPropertiesFile("Password");
		
		
		lp.loginToApp(URL,un, ps);
	}

	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void afterMethod()
	{
		HomePage hp=new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void afterClass()
	{
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() throws SQLException
	{
		dLib.closeDB();
	}

}
