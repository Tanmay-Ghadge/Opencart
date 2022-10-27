package com.Opencart.TestcaseScript;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Opencart.Base.Base;
import com.Opencart.Dataprovider.Dataproviders;
import com.Opencart.PageObjects.CommonElements;
import com.Opencart.PageObjects.ForgotPassword;
import com.Opencart.PageObjects.HomePage;
import com.Opencart.PageObjects.LogIn;
import com.Opencart.PageObjects.LogoutPage;
import com.Opencart.PageObjects.MyAccountPage;
import com.Opencart.PageObjects.RegistrationObjects;
import com.Opencart.actiondriver.ActionDriver;

public class LogoutTests extends Base
{

	WebDriver driver;
	HomePage homePageObject=new HomePage(driver);
	RegistrationObjects registrationObjects;
	CommonElements commonElements=new CommonElements(driver);;
	LogIn loginObject;
	ForgotPassword forgetPasswordObject;
	MyAccountPage myAccountPageObject;
	SoftAssert softAssert=new SoftAssert();
	LogoutPage logoutPageObject;
	
	
	@BeforeMethod
	void setup() throws IOException
	{
		loadConfiguration();
		driver=selectBrowser("chrome");
		homePageObject=openURL();

	} 
	
	//@Test(description ="Validate logging into the Application using valid credentials", 	dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	
	void login() throws InterruptedException //String mail,String pwd
	{
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Log in Page");

		boolean result1=loginObject.login("tanmayghadge@gmail.com","qwerty");
		Assert.assertTrue(result1,"with valid mailID and password failed to log in " );
		
	}
	
	@Test(description ="Validate Logging out by selecting Logout option from 'My Account' dropmenu")
	void logout1() throws InterruptedException
	{
		login();
		logoutPageObject=commonElements.selectMyaccountOptionLogout();
		boolean value=logoutPageObject.pageValidation(driver);
		Assert.assertTrue(value,"failed to land on logout page");	
		
		homePageObject=logoutPageObject.logoutContinue();
		boolean value2=homePageObject.pageValidation(driver);
		Assert.assertTrue(value2,"logout failed with header logout option");	
	}
	
	@Test(description ="Validate Logging out by selecting Logout option from 'My Account' dropmenu")
	void logout2() throws InterruptedException
	{
		login();
		logoutPageObject=commonElements.clickonRightLogoutBtn();
		boolean value=logoutPageObject.pageValidation(driver);
		Assert.assertTrue(value,"logout failed with logout option in right column");
		homePageObject=logoutPageObject.logoutContinue();
		boolean value2=homePageObject.pageValidation(driver);
		Assert.assertTrue(value2,"logout failed with logout option in right column");	
	}
	
	@Test(description ="Validate Logout option is not displayed under'My Account' menu before logging in")
	void logout3() throws InterruptedException
	{
		boolean value=commonElements.isMyaccountOptionPresent("Register");
		Assert.assertFalse(value,"in my account dropdown logout option is present without logging in");
		
		
	}
	
	@Test(description ="Validate logging out and browsing back")
	void logout4() throws InterruptedException, AWTException
	{
		login();
		logoutPageObject=commonElements.selectMyaccountOptionLogout();
		boolean value=logoutPageObject.pageValidation(driver);
		Assert.assertTrue(value,"failed to land on logout page");	
		
		homePageObject=logoutPageObject.logoutContinue();
		boolean value2=homePageObject.pageValidation(driver);
		Assert.assertTrue(value2,"logout failed with header logout option");	
		
		ActionDriver.browserBackwardBTN();
		commonElements.clickonMyAccountRight();
		boolean value3=ActionDriver.getpageTitle(driver,"Account Login");
		Assert.assertTrue(value2,"after logging out still user is not logged out");	
		
		Thread.sleep(2000);
		
	}
	
	
	
}
