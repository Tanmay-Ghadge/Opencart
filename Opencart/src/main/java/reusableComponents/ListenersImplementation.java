package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Opencart.Base.DriverFactory;
import com.Opencart.Base.ExtentReportThreadSafe;
import com.Opencart.Base.ExtentSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImplementation implements ITestListener
{
	ExtentReports extentReport;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) 
	{
		// for each execution
		try
		{
		extentReport=ExtentSetup.extentReportSetup();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		//for each test
		test=extentReport.createTest(result.getMethod().getMethodName());
		ExtentReportThreadSafe.getInstance().setextent(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//when test is passed
		test=ExtentReportThreadSafe.getInstance().getExtent();
		test.log(Status.PASS,"Test case: "+result.getMethod().getMethodName()+" is passed.");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		//when test is failed
		test=ExtentReportThreadSafe.getInstance().getExtent();
		test.log(Status.FAIL,"Test case: "+result.getMethod().getMethodName()+" is failed.");	
		test.log(Status.FAIL,result.getThrowable());
	
		WebDriver driver=DriverFactory.getInstance().getDriver();
		
		//take screenshot for the failed test
		
       TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
        
       File src=takeScreenshot.getScreenshotAs(OutputType.FILE);		
		
       SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH-mm--ss");
       Date date=new Date();
       String actualdate=format.format(date);
       
       String screenShotpath=System.getProperty("user.dir")+"Screenshots"+actualdate+result.getMethod().getMethodName()+".jpeg";
		
	   File destination=new File(screenShotpath);
		
	   try 
	   {
		   FileUtils.copyFile(src, destination);
	   } catch (IOException e)
	   {
		   e.printStackTrace();
	   }

	   ExtentReportThreadSafe.getInstance().getExtent().addScreenCaptureFromPath(screenShotpath,"Test case failure screenshot");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test=ExtentReportThreadSafe.getInstance().getExtent();
		test.log(Status.SKIP,"Test case: "+result.getMethod().getMethodName()+" is Skipped.");	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	} 

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext context)
	{
		extentReport.flush();
	}



}
