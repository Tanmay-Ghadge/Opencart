package com.Opencart.TestcaseScript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Opencart.Base.ExtentReportThreadSafe;
import com.Opencart.Base.TestBase;
import com.aventstack.extentreports.Status;

public class DummyClass extends TestBase
{

	@Test
	public void method1()
	{
      System.out.println("METHOD 2");
		ExtentReportThreadSafe.getInstance().getExtent().log(Status.PASS,"successfully entered value--valueToEnter in field ");
	}
	
	@Test
	public void method2()
	{
      System.out.println("METHOD 2");
	ExtentReportThreadSafe.getInstance().getExtent().log(Status.PASS,"successfully entered value--valueToEnter in field ");
	}
	
}
