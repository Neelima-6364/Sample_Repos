package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Neelima
 * Contains Contact Information page Elements
 */
public class ContactsInformationPage {
	WebDriver driver;
	public ContactsInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="mouseArea_Last Name")
	private WebElement actLastName;

	@FindBy(id ="dtlview_Support Start Date")
	private WebElement actstartdate;

	@FindBy(id ="dtlview_Support End Date")
	private WebElement actenddate;

	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getActstartdate() {
		return actstartdate;
	}

	public WebElement getActenddate() {
		return actenddate;
	}



}
