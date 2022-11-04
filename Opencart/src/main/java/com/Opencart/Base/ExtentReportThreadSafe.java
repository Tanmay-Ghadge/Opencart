package com.Opencart.Base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportThreadSafe 
{
	private ExtentReportThreadSafe()
	{

	}

	private static ExtentReportThreadSafe instance=new ExtentReportThreadSafe();


	public static ExtentReportThreadSafe getInstance()
	{
		return instance;
	}

	ThreadLocal<ExtentTest> extent=new ThreadLocal<ExtentTest>();

	public ExtentTest getDriver()
	{
		return extent.get();
	}
	
	
	public void setDriver(ExtentTest extentTestObject)
	{
		extent.set(extentTestObject);
	}

}
