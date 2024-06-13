package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Contains Organization Page Elements and business Library 
 * @author Neelima
 *
 */
public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgBtn;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement searchEdit;
	
	@FindBy(name = "search_field")
	private WebElement orgdd;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	public WebElement getOrgdd() {
		return orgdd;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	/**
	 * Organization Drop down
	 */
	public void orgDD()
	{
		Select sel=new Select(orgdd);
		sel.selectByIndex(1);
	}


}
