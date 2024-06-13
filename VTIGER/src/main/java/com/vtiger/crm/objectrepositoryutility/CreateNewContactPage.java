package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Contains  Create New Contact page Elements and Business Library
 * @author Neelima
 *
 */
public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDateEdit;

	@FindBy(name = "support_end_date")
	private WebElement supportEndDateEdit;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectOrgBtn;

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSupportStartDateEdit() {
		return supportStartDateEdit;
	}

	public WebElement getSupportEndDateEdit() {
		return supportEndDateEdit;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}
	/**
	 * create contact with last Name text field
	 * @param lastName
	 */
	public void createContact(String lastName)
	{
		getLastNameEdit().sendKeys(lastName);
		getSaveBtn().click();
	}

	/**
	 * create contact with last Name, Start date and End date
	 * @param lastName
	 * @param startdate
	 * @param enddate
	 */
	public void createContact(String lastName, String startdate, String enddate)
	{
		getLastNameEdit().sendKeys(lastName);
		getSupportStartDateEdit().clear();
		getSupportStartDateEdit().sendKeys(startdate);
		getSupportEndDateEdit().clear();
		getSupportEndDateEdit().sendKeys(enddate);
		getSaveBtn().click();
	}

}
