package com.webshop.testcases;
//ctrl+o=to remove the imports.
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLoginPage extends BaseTest{
	@Test(priority = 1 ,enabled=false)
	public void testLoginPageTitle() 
	{
		logger=report.createTest("Test Login Page");
		homePage.clickLoginLink();
		logger.pass("Clicked login link");
		//LoginPage is global variable in Base Test
		String Title = loginPage.GetPageTitle();
		logger.pass("Get Page Title");
		System.out.println("Page Title:"+ Title);
		Assert.assertTrue(Title.contains("Login"));
		logger.pass("Login Page verified");
		}
	
	@Test(priority = 2 ,enabled=false)
	public void testLoginFunction() 
	{
		logger=report.createTest("Test Login Function");
		homePage.clickLoginLink();
		logger.pass("Clicked login link");
		loginPage.enterEmail("selauto1@test.com");
		logger.pass("Enter username");
		loginPage.enterPassword("Pass@123");
		logger.pass("Enter Password");
		loginPage.clickLoginButton();
		logger.pass("clicked login button");
		boolean flag = homePage.IsLogOutLinkDisplayed();
		Assert.assertTrue(flag);
		homePage.clickLogout();
		logger.pass("Login successfull");
}
	@Test(priority = 3 ,enabled=false)
	public void testForgotPasswordDisplayed()
	{
		logger=report.createTest("Test forgot password link displayed");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgorPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is displayed");
	}
	
	
		}

	
	
	

