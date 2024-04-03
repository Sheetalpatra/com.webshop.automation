package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.DriverScript;

public class LoginPage extends DriverScript {
	//****************Page Element*****************
	@FindBy(id="Email") WebElement EmailTextBox;
	@FindBy(name="Password1") WebElement PasswordTextBox;
	@FindBy(xpath=" //input[@value='Log in']") WebElement LoginButton;
	@FindBy(linkText = "Forgot password?") WebElement ForgotPasswordLink;
	
	//****************Page Initialization*************
	public LoginPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	//****************Page Action*****************
	public void enterEmail(String email)
	{
		EmailTextBox.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		PasswordTextBox.sendKeys(password);
	}
	public void clickLoginButton() {
	LoginButton.click();}
	
	public void clickForgotPassword()
	{
		ForgotPasswordLink.click();
	}
	
	public boolean isForgorPasswordLinkDisplayed()
	{
		return ForgotPasswordLink.isDisplayed();
	}
	
	public String GetPageTitle()
	{
		return driver.getTitle();
	}
	
}
