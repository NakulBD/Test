package com.crm.qa.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil= new TestUtil();
	ContactsPage contactsPage;

	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException 
	{
		Initilization();
		loginPage = new LoginPage();		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest()
	{
		String HomePageTitle= homePage.VerifyTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void VerifyUserName()
	{
		TestUtil.switchToFrame();
		boolean Username= homePage.VerifyUserName();
		Assert.assertTrue(Username);
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		TestUtil.switchToFrame();
		contactsPage=homePage.ClickOnContacts();
		
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}	
	
}
