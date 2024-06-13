package com.vtiger.crm.objectrepositoryutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;

/**
 * Contains Login Page Elements and Business Methods
 * @author Neelima
 *
 */
public class LoginPage extends WebdriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdit;

	@FindBy(name="user_password")
	private WebElement passwordEdit;

	@FindBy(id="submitButton")
	private WebElement loginBtn;


	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * Login to Application with URL,UserName and Password
	 * @param URL
	 * @param un
	 * @param ps
	 * @throws IOException
	 */
	public void loginToApp(String URL, String un, String ps) throws IOException
	{
		waitForpagetoLoad(driver);
		driver.get(URL);
		usernameEdit.sendKeys(un);
		passwordEdit.sendKeys(ps);
		loginBtn.click();
	}
	

}
