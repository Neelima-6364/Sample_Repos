package com.vtiger.crm.orgtest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.BaseClass.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassobject;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInformationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.vtiger.crm.ListnerUtility.ListnerImplementation.class)
public class CreateOrgTest extends BaseClass {
	@Test(groups = {"smokeTest"})
	public void createOrgWithMandField() throws EncryptedDocumentException, IOException
	{
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		
		/*get test data from excel*/
		String orgName = eLib.getDataFromExcelFile("Org", 1, 2)+ jLib.getRandomNumber();

		/*Navigate to Organization Module*/
		HomePage hp=new HomePage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Organization List page");
		hp.getOrganizationLink().click();
		
		OrganizationsPage orgp=new OrganizationsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Organization page");
		orgp.getCreateOrgBtn().click();
		
		/* create organization with organization name*/
		CreateNewOrganizationPage crneworgp=new CreateNewOrganizationPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Enter OrgName and create Organization");
		crneworgp.createOrganization(orgName);

		/*verify header oganisation actual data*/
		OrganizationInformationPage orginfop=new OrganizationInformationPage(driver);
		String headerinfo =orginfop.getHeaderinfo().getText();

		Assert.assertEquals(true, headerinfo.contains(orgName));
		UtilityClassobject.getTest().log(Status.INFO,"Header Info verified");
	}	
	
	
	@Test(groups ="regressionTest")
	public void createOrgwithIndustry() throws EncryptedDocumentException, IOException
	{
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		/*Get date from Excel*/
		String orgName = eLib.getDataFromExcelFile("Org", 4, 2)+ jLib.getRandomNumber();
		String industry = eLib.getDataFromExcelFile("Org", 4, 3);
		String type = eLib.getDataFromExcelFile("Org", 4, 4);
		

		/*navigate to organization module*/
		HomePage hp=new HomePage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Organization List page");
		hp.getOrganizationLink().click();

		/*click on create organization button*/
		OrganizationsPage orgp=new OrganizationsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Organization page");
		orgp.getCreateOrgBtn().click();

		/*enter all details and create org*/
		CreateNewOrganizationPage crneworgp=new CreateNewOrganizationPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Enter OrgName, select Industry, select Type and create Organization");
		crneworgp.createOrganization(orgName, industry, type);

		/*verify the orgName present in the header info*/
		OrganizationInformationPage orginfop=new OrganizationInformationPage(driver);
		String actOrgname =orginfop.getActOrgName().getText();

		SoftAssert s=new SoftAssert();
		s.assertEquals(actOrgname, orgName);
		UtilityClassobject.getTest().log(Status.INFO,"Organation Info verified");

		/*verify the drop down industry and type*/
		String actindustry = orginfop.getActindustry().getText();
		s.assertEquals(actindustry, industry);
		UtilityClassobject.getTest().log(Status.INFO,"Industry Info verified");

		String acttype =orginfop.getActtype().getText();
		s.assertEquals(acttype, type);
		UtilityClassobject.getTest().log(Status.INFO,"Type Info verified");
	
		s.assertAll();

	}
	
	
	@Test(groups ="regressionTest")
	public void createOrgwithMobileNum() throws EncryptedDocumentException, IOException
	{
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		String orgName = eLib.getDataFromExcelFile("Org", 7, 2)+ jLib.getRandomNumber();
		String phNum = eLib.getDataFromExcelFile("Org", 7, 3);

		/*navigate to organization midule*/
		HomePage hp=new HomePage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Organization List page");
		hp.getOrganizationLink().click();

		/*click on create organization button*/
		OrganizationsPage orgp=new OrganizationsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Organization page");
		orgp.getCreateOrgBtn().click();

		/*enter all details and create org*/
		CreateNewOrganizationPage crneworgp=new CreateNewOrganizationPage(driver);
		UtilityClassobject.getTest().log(Status.INFO,"Enter Org Name and Phonenumber and create Organization");
		crneworgp.createOrganization(orgName, phNum);

		OrganizationInformationPage orginfop=new OrganizationInformationPage(driver);
		String enteredPhNum =orginfop.getEnteredMobileNum().getText().trim();

		Assert.assertEquals(enteredPhNum, phNum);
		UtilityClassobject.getTest().log(Status.INFO,"PhoneNumber Info verified");
	}
	@Test
	public void m()
	{
		System.out.println("create Org");
	}

}
