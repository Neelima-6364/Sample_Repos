package com.vtiger.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void waitForpagetoLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> i=set.iterator();

		while(i.hasNext())
		{
			String wid = i.next();
			driver.switchTo().window(wid);

			String currentTitle = driver.getTitle();
			if(currentTitle.contains(partialTitle))
			{
				break;
			}
		}
	}

	public void switchToTabOnCurrentUrl(WebDriver driver, String partialUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> i=set.iterator();

		while(i.hasNext())
		{
			String wid = i.next();
			driver.switchTo().window(wid);

			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains(partialUrl))
			{
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameId)
	{
		driver.switchTo().frame(nameId);
	}
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement element, String visText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visText);
	}
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void mouseMoveToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void mouseDoubleClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
}