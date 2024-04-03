package com.webshop.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverScript {
	/*
	 * public driver referance which can be accessed across the project
	 * prop global variable to access properties class method in all test.
	 */
	public static WebDriver driver;
	Properties prop;
	/*
	 * This constructor is responsible for loading the properties file
	 */
	public DriverScript() {
		try 
		{
		File file = new File("./src/test/resources/ConfigFile/config.properties")	;
		FileInputStream fis = new FileInputStream(file);
		 prop = new Properties();
		prop.load(fis);
		
		}
		catch (Exception e) 
		{
			System.out.println("Unable toload properties file");
			e.printStackTrace();
		}
	}
	/*
	 * This method is used to launch the browser and navigate.
	 */
	
	public void initApplication() {
		String browser = prop.getProperty("browser");
		if (browser.trim().equalsIgnoreCase("chrome"))
		{
			System.out.println("Broswer Inuse:"+browser);
			driver=new ChromeDriver();
		}
		else if (browser.trim().equalsIgnoreCase("firefox")) 
		{
		System.out.println("Browser Inuse"+browser);
		driver=new FirefoxDriver();
		}
		else if (browser.trim().equalsIgnoreCase("edge")) 
		{
		System.out.println("browser Inuse:"+browser);	
		driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Unsupported Browser Type");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://demowebshop.tricentis.com/");
		//driver.get("https://www.google.com/");
		//driver.quit();
		getUrl();
		}
	/*
	 * this method is to get the URL from the properties file.
	 */
		public  void getUrl() {
		String url = prop.getProperty("url")	;
		driver.get(url);
		}
		/*
		 * This method will quit the browser
		 */
		
			public static void quitDriver() {
				driver.quit();
			}
			
	}

			
		


