package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Nakul Mahajan')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContact; 
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyUserName()
	{
		return userNameLabel.isDisplayed();
		
	}
	public String VerifyTitle()
	{
		return driver.getTitle();
		
	}
	
	public ContactsPage ClickOnContacts()
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasksPage()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void ClickOnNewContactLink()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactLink).perform();
		newContact.click();
		
	}
	

}
