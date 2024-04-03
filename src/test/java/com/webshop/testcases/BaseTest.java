package com.webshop.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.base.DriverScript;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import com.webshop.pages.PasswordRecoverPage;
import com.webshop.utils.Helper;


public class BaseTest extends DriverScript {
	HomePage homePage;
	LoginPage loginPage;
	PasswordRecoverPage PR;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	
@BeforeSuite
	public void setUpReport()
	{
	ExtentHtmlReporter extent = new ExtentHtmlReporter("./TestReport/wsreport.html");
	 report = new ExtentReports();
	report.attachReporter(extent);
	}
	@BeforeMethod
public void setUp()
{
		initApplication();
		 homePage = new HomePage();
		 loginPage = new LoginPage();
		 PR = new PasswordRecoverPage();
		

}
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			try {logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		report.flush();
		Thread.sleep(4000);
		quitDriver();
	}
}
}
