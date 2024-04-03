package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.DriverScript;

public class HomePage extends DriverScript
{
//****************Page Element******
	@FindBy(linkText = "Log in")WebElement loginLink;
	@FindBy(linkText = "Log out")WebElement logoutlink;
	
	//****************Page initiaization******
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//****************Page Action/Method************
	
	public String GetHomePageTitle() 
	{
return driver.getTitle();
	}
	public void clickLoginLink ()
	{
		loginLink.click();
	}
	public boolean IsLogOutLinkDisplayed()
	{
		return logoutlink.isDisplayed();
	}
	
	public void clickLogout()
	{
	 logoutlink.click();
	}
}
