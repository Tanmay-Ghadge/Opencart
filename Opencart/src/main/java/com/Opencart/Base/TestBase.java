package com.Opencart.Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.PropertiesOperations;

public class TestBase 
{
	BrowserFactory browserFactoryObject=new BrowserFactory();

	@BeforeMethod
	public void launchApplication() throws Exception
	{
		PropertiesOperations properties=new PropertiesOperations();
		String browser=properties.getPropertiesValue("browser");
		String url=properties.getPropertiesValue("url");
		
		DriverFactory.getInstance().setDriver(browserFactoryObject.selectBrowser(browser));
		
		WebDriver driver=DriverFactory.getInstance().getDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@AfterMethod
	public void teardown()
	{
		DriverFactory.getInstance().closeBrowser();
		
	}
	
	
	
}
