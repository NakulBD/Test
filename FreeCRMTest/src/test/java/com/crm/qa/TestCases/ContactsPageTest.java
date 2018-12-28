package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;
	TestUtil testutil;
	String SheetName ="Contacts";
	
	

	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Initilization();
		loginpage = new LoginPage();
		testutil=new TestUtil();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		contactpage = homepage.ClickOnContacts();
	}

	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactpage.verifyContactsPageLogo());
	}
	@Test(priority=2)
	public void selectSingleContactTest() {
	
	
		contactpage.selectContactByName("Nakul Mahajan");
	}

	@Test(priority=3)
	public void selectMultipleContactTest() {

		contactpage.selectContactByName("Nakul Mahajan");
		contactpage.selectContactByName("Nik Mahajan");
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] =TestUtil.getTestData(SheetName);
		return data;
	}
		
	@Test(priority=4, dataProvider="getCRMTestData")
	    public void ValidateCreateNewContact(String title, String firstName, String lastName, String Company) {		
		homepage.ClickOnNewContactLink();
		contactpage.CreateNewContact(title,firstName,lastName,Company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}

	
	



