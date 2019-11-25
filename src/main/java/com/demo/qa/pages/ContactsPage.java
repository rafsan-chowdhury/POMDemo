package com.demo.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.qa.base.BasePage;

public class ContactsPage  extends BasePage{

	By contactsLabel= By.xpath("//text()[contains(.,'Contacts')]/ancestor::div[1]");

	By addNewContactBtn= By.xpath("//text()[.='New']/ancestor::button[1]");
	
	By newContactLabel= By.xpath("//text()[contains(.,'Create New Contact')]/ancestor::div[1]");

	By firstName= By.name("first_name");
	
	By lastName= By.name("last_name");
	
	By saveBtn= By.xpath("//text()[.='Save']/ancestor::button[1]");
			
	By tableRows = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr/td[2]");
	
	String tablePath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/";
	
	static int preRowNum;
	
	static int rowNum;
	
	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyContactsLabel(){
		return isDisplayed(contactsLabel);
	}
	
	public String verifyContactsPageTitle(){
		return getPageTitle();
	}
	
	public void selectContactsByName(String name){	
		doClick(By.xpath("//td[text()='"+name+"']"));
	}
	
	public boolean isContactSelected(String searchKeyword) {
		int rowNumber= getTableRowNumber(tableRows, tablePath, searchKeyword);
		
		return isChecked(By.xpath(tablePath+"tr["+rowNumber+"]/td[1]//input[@name='id']"));
	}
	
	public void clickOnNewContact() {
		doClick(addNewContactBtn);
	}
	public boolean verifyNewContactsLabel(){
		return isDisplayed(newContactLabel);
	}
	
	public void createNewContact(String fName, String lName) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		preRowNum=getTotalRowCount(tableRows);
		doClick(addNewContactBtn);
		doSendKeys(firstName, fName);
		doSendKeys(lastName, lName);
		doClick(saveBtn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean verifyCreateNewContact() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rowNum=getTotalRowCount(tableRows);
		if(preRowNum<rowNum)
		{
			return true;
		}
		return false;
	}
	
}
