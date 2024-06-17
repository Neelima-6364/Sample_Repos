
package com.vtiger.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.BaseClass.BaseClass;
import com.vtiger.crm.ListnerUtility.ListnerImplementation;
import com.vtiger.crm.generic.webdriverutility.UtilityClassobject;
import com.vtiger.crm.objectrepositoryutility.ContactsInformationPage;
import com.vtiger.crm.objectrepositoryutility.ContactsPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInformationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationListPopupPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;

 // for Class level
public class CreateContactTest extends BaseClass{

	@Test(groups ="smokeTest")
	public void createContactWithLastName() throws EncryptedDocumentException, IOException
	{
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		
		/*Get test data from excel*/
		String lastName = eLib.getDataFromExcelFile("Contact", 1, 2)+ jLib.getRandomNumber();
		ContactsInformationPage coninfop=new ContactsInformationPage(driver);
		
		/*Navigate to Contact List page*/
		HomePage hp=new HomePage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Contact List page");
		hp.getContactLink().click();

		/*click on create contact button*/
		/*navigate to contact module*/
		ContactsPage cp=new ContactsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Contact page");
		cp.getCreateContactBtn().click();

		/*enter all details and create con*/
		CreateNewContactPage crnewconp=new CreateNewContactPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Enter lastName and create contact");
		crnewconp.createContact(lastName);

		String actlastName = coninfop.getActLastName().getText().trim();
		
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(actlastName, lastName);
		UtilityClassobject.getTest().log(Status.INFO,"LastName Info verified in contact information page");
		sf.assertAll();
	}

	@Test(groups ="regressionTest")
	public void createConWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		
		/*get test data from excel*/
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		String lastName = eLib.getDataFromExcelFile("Contact", 1, 2)+ jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcelFile("Contact", 7, 3)+ jLib.getRandomNumber();
		
		/*Navigate to Organization List page*/
		HomePage hp=new HomePage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Organization List page");
		hp.getOrganizationLink().click();
		
		/*Navigate to create Organization page*/
		OrganizationsPage orgp=new OrganizationsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Organization page");
		orgp.getCreateOrgBtn().click();
		
		/*Enter Organization name and create organization*/
		CreateNewOrganizationPage crneworgp=new CreateNewOrganizationPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Enter Organization name and create organization");
		crneworgp.createOrganization(orgName);

		OrganizationInformationPage orginfop=new OrganizationInformationPage(driver);
		String headerinfo = orginfop.getHeaderinfo().getText();
		
		Assert.assertTrue(headerinfo.contains(orgName));
		UtilityClassobject.getTest().log(Status.INFO,"OrgName Info verified in organization Information page");
	
		Thread.sleep(2000);

		/*navigate to contact module*/
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Contact List page");
		hp.getContactLink().click();

		/*click on create contact button*/
		ContactsPage cp=new ContactsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Contact page");
		cp.getCreateContactBtn().click();

		/*enter all details and create con*/
		CreateNewContactPage crnewconp=new CreateNewContactPage(driver);
		crnewconp.getLastNameEdit().sendKeys(lastName);
		UtilityClassobject.getTest().log(Status.INFO, "Enter last name and select Organization Button");
		crnewconp.getSelectOrgBtn().click();

		UtilityClassobject.getTest().log(Status.INFO, "switch to organization list popup");
		wLib.switchToTabOnCurrentUrl(driver, "Accounts&action=");

		OrganizationListPopupPage orglistpp=new OrganizationListPopupPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Select OrgName in Organization List popup page");
		orglistpp.selectOrg(orgName);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Create Contact page and create contact");
		wLib.switchToTabOnCurrentUrl(driver, "Contacts&action");
		crnewconp.getSaveBtn().click();	

	}

	@Test(groups ="regressionTest")
	public void createConWithSupportDate() throws EncryptedDocumentException, IOException
	{
		UtilityClassobject.getTest().log(Status.INFO, "Read data from Excel");
		/*Get test data from Excel*/
		String lastName = eLib.getDataFromExcelFile("Contact", 4, 2)+ jLib.getRandomNumber();

		/*navigate to contact module*/
		HomePage hp=new HomePage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to Contact List page");
		hp.getContactLink().click();

		/*click on create contact button*/
		ContactsPage cp=new ContactsPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Navigate to create Contact page");
		cp.getCreateContactBtn().click();

		/*date*/
		String actualstartDate =jLib.getSystemDateYYYYMMDD();
		String endDate=jLib.getrequiredDateYYYYMMDD(30);

		/*enter all details and create con*/
		CreateNewContactPage crnewconp=new CreateNewContactPage(driver);
		UtilityClassobject.getTest().log(Status.INFO, "Create Contact with lastName, StartDate and EndDate");
		crnewconp.createContact(lastName, actualstartDate, endDate);

		ContactsInformationPage coninfop=new ContactsInformationPage(driver);
		String actlastName = coninfop.getActLastName().getText().trim();
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(actlastName, lastName);
		UtilityClassobject.getTest().log(Status.INFO,"LastName Info verified");
	
		String actstartdate =coninfop.getActstartdate().getText();
		sf.assertEquals(actstartdate, actualstartDate);
		UtilityClassobject.getTest().log(Status.INFO,"Startdate Info verified");

		String actenddate = coninfop.getActenddate().getText();
		sf.assertEquals(actenddate, endDate);
		UtilityClassobject.getTest().log(Status.INFO,"EndDate Info verified");
		
		sf.assertAll();
	}
}
