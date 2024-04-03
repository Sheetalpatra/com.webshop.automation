package com.webshop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
//PR = new PasswordRecoverPage();-PR is the object of Passwordrecoverpage.

public class TestPasswordRecoverPage extends BaseTest 
{
	@Test(priority = 1)
	public void PasswordRecoveryTest ()
	{
		logger=report.createTest("Password Recover");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgorPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		
		logger.pass("forgot password link is displayed");
		loginPage.clickForgotPassword();
		logger.pass("Clicked on Forgot Password link");
		
		
		logger.pass("Password recovery text is present");
		boolean actual = PR.isPasswordRecoveryTextIsDisplayed();
		System.out.println(actual);
		Assert.assertTrue(actual);
		logger.pass("Password recovery text  present");
		
		
	
	logger.pass("clicked Password recover link");
		 String PRT = PR.RecoveryPageTitle();
		 System.out.println(PRT);
		 logger.pass("Recovery pageTitle Validated");
		 
		 PR.RecoveryEmail("selauto1@test.com");
		 logger.pass("Enter Valid Recover email");
		PR.ClickRecover();
		String EmailInstructionMsg = PR.getemailInstructionSentMsg();
		System.out.println(EmailInstructionMsg);
		logger.pass("Clicked Recovery Button");
		Assert.assertTrue( EmailInstructionMsg.contains("Email with instructions has been sent"));
		logger.pass("Email with Instruction sent");
		
		
	 String PRE = PR.PasswordText();
	System.out.println(PRE);
	Assert.assertTrue(PRE.contains("recovery"));
	logger.pass("Recovery Text Validated");
	}
	
	@Test(priority = 2)
	public void testInvalidEmailAddress()
	{
		logger=report.createTest("Test Invalid Emiail Address");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgorPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		
		logger.pass("forgot password link is displayed");
		loginPage.clickForgotPassword();
		logger.pass("Clicked on Forgot Password link");
		
		logger.pass("Wrong email Displayed");
		PR.RecoveryEmail("ss");
		logger.pass("entered Invalid Email");
		
		PR.ClickRecover();
		logger.pass("Cliked recovery Button");
		
		
	logger.pass("Get wrong email msg")	;	
	String WrongMessage = PR.getWrongEmailMsg();
	System.out.println("WrongMessage:"+ WrongMessage);
	Assert.assertTrue( WrongMessage.contains("Wrong"));
	logger.pass("Got Wrong message verigfied");
	
	
		{
			
		}
	}
	public void testValidEmailmessage()
	{
		 PR.RecoveryEmail("selauto1@test.com");
		 logger.pass("Enter Valid Recover email");
		PR.ClickRecover();
		String EmailInstructionMsg = PR.getemailInstructionSentMsg();
		System.out.println(EmailInstructionMsg);
		logger.pass("Clicked Recovery Button");
		//Assert.assertTrue( EmailInstructionMsg.contains("Email with instructions has been sent"));
		logger.pass("Email with Instruction sent");
		driver.quit();
	}
}

