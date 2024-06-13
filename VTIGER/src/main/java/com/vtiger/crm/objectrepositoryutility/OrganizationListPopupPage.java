package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Contains Organization List page Elements and Business Libraries
 * @author Neelima
 *
 */
public class OrganizationListPopupPage {
	WebDriver driver;
	public OrganizationListPopupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="search_txt")
	private WebElement searchEdit;

	@FindBy(name="search")
	private WebElement searchBtn;
	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	/**
	 * Select Organization with Organization Name
	 * @param orgName
	 */
	public void selectOrg(String orgName)
	{
		getSearchEdit().sendKeys(orgName);
		getSearchBtn().click();
	}
}