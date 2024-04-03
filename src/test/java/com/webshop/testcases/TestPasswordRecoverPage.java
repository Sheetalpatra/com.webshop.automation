package com.webshop.testcases;

import org.testng.annotations.Test;

public class TestPasswordRecover extends BaseTest 
{
	@Test(priority = 1,enabled=true)
	public void PasswordRecoveryTest ()
	{
		logger=report.createTest("Password Recover");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		PR.Forgotpassword();
	
	logger.pass("clicked Password recover link");
		 String PRT = PR.RecoveryPageTitle();
		 System.out.println(PRT);
		 logger.pass("Recovery pageTitle");
		 
		 PR.RecoveryEmail("selauto1@test.com");
		 logger.pass("Enter Recover email");
		PR.ClickRecover();
		logger.pass("Clicked Recovery Button");
		
	 String PRE = PR.PasswordText();
	System.out.println(PRE);
	logger.pass("Recover Text");
	
		}

}
