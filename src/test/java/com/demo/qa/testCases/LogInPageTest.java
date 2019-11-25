package com.demo.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LogInPage;

public class LogInPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void landingPageTitleTest() {
		String title= page.getInstance(LogInPage.class).validateLandingPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority = 2)
	public void logoImageTest() {
		boolean flag= page.getInstance(LogInPage.class).validateImage();
		Assert.assertTrue(flag);
		//throw new SkipException("This is skiped");
		//Assert.assertEquals("a", "1Free CRM #1 cloud software for any business large or small");

	}

	@Test(priority = 3)
	public void logInTest() {
		HomePage homePage= page.getInstance(LogInPage.class).login(prop.getProperty("username"), "password");
		String title= homePage.getPageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home page title not matched");
	}
	
}
