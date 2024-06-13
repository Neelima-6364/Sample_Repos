package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Contains Organization Information page Elements 
 * @author Neelima
 *
 */
public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="mouseArea_Industry")
	private WebElement actindustry;

	@FindBy(id="mouseArea_Type")
	private WebElement acttype;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerinfo;

	@FindBy(id="dtlview_Organization Name")
	private WebElement actOrgName;

	@FindBy(id = "mouseArea_Phone")
	private WebElement enteredMobileNum;

	public WebElement getEnteredMobileNum() {
		return enteredMobileNum;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActindustry() {
		return actindustry;
	}

	public WebElement getActtype() {
		return acttype;
	}

	public WebElement getHeaderinfo() {
		return headerinfo;
	}
	

}
