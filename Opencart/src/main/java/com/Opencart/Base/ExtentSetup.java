package com.Opencart.Base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import reusableComponents.PropertiesOperations;

public class ExtentSetup
{
	static ExtentReports extent;
	
	public static ExtentReports extentReportSetup() throws Exception
	{
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date=new Date();
		String actualDate=format.format(date);
		String reportPath=".//Reports/ExecutionReport_"+actualDate+".html";
		
		ExtentSparkReporter sparkReport=new ExtentSparkReporter(reportPath);
		
		extent=new ExtentReports();
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setReportName("ReportName");
		
		extent.setSystemInfo("Executed on Environment", PropertiesOperations.getPropertiesValue("url"));
		extent.setSystemInfo("Executed on Browser", PropertiesOperations.getPropertiesValue("browser"));
		extent.setSystemInfo("Executed on OS", System.getProperty("os.name"));
		extent.setSystemInfo("Executed on user", System.getProperty("user.name"));
		
		return extent;
		
		
		
	}
}
