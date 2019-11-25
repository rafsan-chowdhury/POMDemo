package com.demo.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demo.qa.base.BasePage;

public class LogInPage extends BasePage{
	
	

	By userName= By.name("email");
//	@FindBy(name="email")
//	WebElement userName;
	
	By password= By.name("password");
//	@FindBy(name="password")
//	WebElement password;
	
	By logInPageBtn= By.xpath("//text()[.='Log In']/ancestor::a[1]");
//	@FindBy(xpath="//text()[.='Log In']/ancestor::a[1]")
//	WebElement logInPageBtn;
	
	By logInSubmitBtn= By.xpath("//div[text()='Login']");
//	@FindBy(xpath="//div[text()='Login']")
//	WebElement logInSubmitBtn;
	
	By signUpBtn= By.xpath("//button[contains(text(),'Sign Up')]");
//	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
//	WebElement signUpBtn;
	
	By logo= By.cssSelector("image[src='/images/cogtiny1.jpg']");
//	@FindBy(css = "image[src='/images/cogtiny1.jpg']")
//	WebElement logo;
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	public String validateLandingPageTitle() {
		return getPageTitle();
	}
	
	
	public boolean validateImage() {
		return isDisplayed(logo);
	}
	
	public HomePage login(String username, String pass) {
		doClick(logInPageBtn);
		doSendKeys(userName, username);
		doSendKeys(password, pass);
		doClick(logInSubmitBtn);
		return getInstance(HomePage.class);
	}
	
	public void login() {
		doClick(logInPageBtn);
		doSendKeys(userName, "");
		doSendKeys(password, "");
		doClick(logInSubmitBtn);
	}
	
	public void login(String cred) {
		try {
			doClick(logInPageBtn);
			if(cred.contains("username")) {
				doSendKeys(userName, cred.split(":")[1].trim());
			} else if(cred.contains("password")) {
				doSendKeys(password, cred.split(":")[1].trim());
			}
			doClick(logInSubmitBtn);
		} catch(Exception e)
		{
			System.out.println("Please type your credentials in this format=> username:abc OR password:abc");
			System.out.println(e.getMessage()); 
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		
		
	}

	
	

}
