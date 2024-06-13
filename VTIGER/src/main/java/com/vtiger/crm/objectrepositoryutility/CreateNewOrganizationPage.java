package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * Contains create New Organization page Elements and Business Library
 * @author Neelima
 *
 */
public class CreateNewOrganizationPage {
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="accountname")
	private WebElement orgnameEdit;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement Industrydropdown;

	@FindBy(name = "accounttype")
	private WebElement typedropdown;

	@FindBy(id = "phone")
	private WebElement phone;

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getOrgnameEdit() {
		return orgnameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustrydropdown() {
		return Industrydropdown;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}
	/**
	 * create Organization with Organization Name
	 * @param orgName
	 */
	public void createOrganization(String orgName)
	{
		orgnameEdit.sendKeys(orgName);
		saveBtn.click();
	}

	/**
	 * create Organization with Organization name, Industry and Type
	 * @param orgName
	 * @param industry
	 * @param type
	 */
	public void createOrganization(String orgName, String industry, String type)
	{
		orgnameEdit.sendKeys(orgName);
		Select sel=new Select(Industrydropdown);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(typedropdown);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}

	/**
	 * create Organization with Organization name and Mobile Number
	 * @param orgName
	 * @param mobileNum
	 */
	public void createOrganization(String orgName, String mobileNum)
	{
		orgnameEdit.sendKeys(orgName);
		phone.sendKeys(mobileNum);
		saveBtn.click();
	}



}
