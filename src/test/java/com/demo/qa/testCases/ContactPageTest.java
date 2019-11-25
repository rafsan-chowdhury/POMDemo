package com.demo.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.qa.pages.ContactsPage;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LogInPage;
import com.demo.qa.testUtils.TestUtil;

public class ContactPageTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");

	}

	@Test(priority=2)
	public void selectSingleContactsTest(){
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		driver.navigate().refresh();
		contactsPage.selectContactsByName("Akif Ahmed");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(contactsPage.isContactSelected("Akif Ahmed"), "contact is not selected");

	}
	
	@DataProvider(name = "ContactData")
	public Object[][] getTestData() {
		Object data[][]=TestUtil.getTestData("Contact");
		return data;
	}
	
	@Test(priority=3)
	public void verifyNewContactPageLabelTest() {
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		contactsPage.clickOnNewContact();
		Assert.assertTrue(contactsPage.verifyNewContactsLabel(), "new contacts label is missing on the page");
		
	}
	
	@Test(priority=4, dataProvider = "ContactData")
	public void createNewContactTest(String FirstName, String LastName) {
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		driver.navigate().refresh();
		contactsPage.createNewContact(FirstName, LastName);
		contactsPage = homePage.clickOnContactsLink();
		driver.navigate().refresh();
		Assert.assertTrue(contactsPage.verifyCreateNewContact(), "no contact has been created");
		
	}

}
