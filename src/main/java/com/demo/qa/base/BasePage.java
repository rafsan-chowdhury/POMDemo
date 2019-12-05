package com.demo.qa.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void doClick(By locator) {
		waitForElementPresent(locator);
		getElement(locator).click();
	}

	@Override
	public void doSendKeys(By locator, String text) {
		waitForElementPresent(locator);
		getElement(locator).sendKeys(text);
	}

	@Override
	public String doGetText(By locator) {
		waitForElementPresent(locator);
		return getElement(locator).getText();
	}

	@Override
	public boolean isDisplayed(By locator) {
		waitForElementPresent(locator);
		return getElement(locator).isDisplayed();
	}

	@Override
	public boolean isChecked(By locator) {
		waitForElementPresent(locator);
		return getElement(locator).isSelected();
	}
  
	@Override
	public int getTableRowNumber(By rowLocator, String tablePath , String searchKeyword) {
		waitForElementPresent(rowLocator);
		List<WebElement> row=getElements(rowLocator);
		for(int i=1;i<row.size();i++)
		{
			By locator= By.xpath(tablePath+"tr["+i+"]/td[2]");
			if(getElement(locator).getText().equalsIgnoreCase(searchKeyword)) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public int getTotalRowCount(By rowLocator) {
		waitForElementPresent(rowLocator);
		return getElements(rowLocator).size();
	}
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			element= driver.findElement(locator);
			return element;
		}catch(Exception e)
		{
			System.out.println("Some exception/error occurde while creating element "+locator.toString());
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return element;
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> element=null;
		try {
			element= driver.findElements(locator);
			return element;
		}catch(Exception e)
		{
			System.out.println("Some exception/error occurde while creating elements "+locator.toString());
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator) );
		} catch(Exception e) {
			System.out.println("Some exception/error occurde while waiting for the element "+locator.toString());
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title) );
		} catch(Exception e) {
			System.out.println("Some exception/error occurde while waiting for the title "+title);
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
	}



}
