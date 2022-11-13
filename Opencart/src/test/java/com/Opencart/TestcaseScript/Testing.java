package com.Opencart.TestcaseScript;

import org.testng.annotations.Test;

import com.Opencart.Base.MyLogger;
import com.Opencart.Base.TestBase;

public class Testing
{
	@Test
	public void test1()
	{
		System.out.println("first test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("test1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("second test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("test2");
	}
	
	@Test
	public void test3()
	{
		System.out.println("third test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("test3");
	}
	
}
