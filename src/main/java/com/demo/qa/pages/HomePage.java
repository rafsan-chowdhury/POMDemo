package com.demo.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.qa.base.BasePage;

public class HomePage extends BasePage {

	By userNameLabel= By.xpath("//span[text()='Rafsan Chowdhury']");

	By contactsLink= By.xpath("//span[text()='Contacts']");

	By dealsLink= By.xpath("//span[text()='Deals']");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String verifyHomePageTitle(){
		return getPageTitle();
	}

	public boolean verifyCorrectUserName(){
		return isDisplayed(userNameLabel);
	}

	public ContactsPage clickOnContactsLink(){
		doClick(contactsLink);
		return getInstance(ContactsPage.class);
	}

}
