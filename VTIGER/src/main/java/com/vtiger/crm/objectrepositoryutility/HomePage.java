package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Contains Home Page Elements and Business methods
 * @author Neelima
 *
 */
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organizationLink;

	@FindBy(xpath = "(//a[text()='Contacts'])[1]")
	private WebElement contactLink;

	@FindBy(xpath = "(//a[text()='Leads'])[1]")
	private WebElement leadLink;

	@FindBy(xpath = "(//a[text()='Opportunities'])[1]")
	private WebElement oppurtunitiesLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;

	@FindBy(xpath="//a[text()='Sign Out']")
	private	WebElement signOutBtn;

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOppurtunitiesLink() {
		return oppurtunitiesLink;
	}

/**
 * Logout the Application
 */
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(administrator).perform();
		getSignOutBtn().click();
	}


}
