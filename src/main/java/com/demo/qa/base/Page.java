package com.demo.qa.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver= driver;
		wait= new WebDriverWait(this.driver, 20);
	}
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract List<WebElement> getElements(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> pageClass)
	{
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	
	
}
