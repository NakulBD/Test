package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {

	//--Page Factory-OR
	@FindBy(name = "username")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement passWord;

	@FindBy(xpath="//input[@value='Login']")
	WebElement Login;

	@FindBy(xpath = "//button[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[contains(@alt,'free crm logo')]")
	WebElement crmLogo;
	
	//--Initializing the Objects of class
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	//Actions
		public String validatePageTitle() {
			return (driver.getTitle());
		}
		public boolean valdiateCRMImage()
		{
			return(crmLogo.isDisplayed());
		}
	
	public HomePage login(String usern, String password) throws InterruptedException
	{
		userName.sendKeys(usern);
		passWord.sendKeys(password);
		
		Thread.sleep(20000L);
		Login.click();
		return new HomePage();
	}
	
	
	
	
}
