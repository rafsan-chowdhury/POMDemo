package com.demo.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.qa.pages.ContactsPage;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LogInPage;

public class HomePageTest extends BaseTest  {

	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");

	}
	
	
}
