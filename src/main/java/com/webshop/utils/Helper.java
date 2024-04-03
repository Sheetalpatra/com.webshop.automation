package com.webshop.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper  {

	public static String captureScreen(WebDriver driver)
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenPath="C:\\Java Workspace Batch29\\com.qa.webshop\\TestReport\\ScreenShots\\screen.png";
		try
		{
		FileHandler.copy(Source, new File(ScreenPath));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ScreenPath;
		
	}


	}
	

