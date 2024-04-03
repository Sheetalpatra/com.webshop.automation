package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.DriverScript;

public class PasswordRecoverPage extends DriverScript
{
	//****************Page Element******	
@FindBy(xpath = "/h1[text()='Password recovery']")WebElement PasswordRecoveryText;
@FindBy(linkText="Forgot password?")WebElement ForgotPassword;
@FindBy(id="Email")WebElement YourEmailAddress;
@FindBy(name="send-email") WebElement Recover;
//****************Page initiaization******
	public PasswordRecoverPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//****************Page Action/Method************
	
public void Forgotpassword()
{
	ForgotPassword.click();
}
public String RecoveryPageTitle()
{
	return driver.getTitle();
	
}
public void RecoveryEmail(String Email)
{
	YourEmailAddress.sendKeys(Email);
}
public void ClickRecover()
{
	Recover.click();
	
}
public String PasswordText()
{
	 return PasswordRecoveryText.getText();
	
}
}