package com.Opencart.TestcaseScript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Opencart.Base.TestBase;
import com.Opencart.PageObjects.CommonElements;
import com.Opencart.PageObjects.ForgotPassword;
import com.Opencart.PageObjects.HomePage;
import com.Opencart.PageObjects.LogIn;
import com.Opencart.PageObjects.MyAccountPage;
import com.Opencart.PageObjects.RegistrationObjects;
import com.Opencart.PageObjects.SearchedElements;

public class SearchProductTests extends TestBase
{

	WebDriver driver;
	HomePage homePageObject=new HomePage(driver);
	RegistrationObjects registrationObjects;
	CommonElements commonElements;
	LogIn loginObject;
	ForgotPassword forgetPasswordObject;
	MyAccountPage myAccountPageObject;
	SearchedElements searchedElements;
	
	SoftAssert softAssert=new SoftAssert();

	@Test(description ="Validate searching with an existing Product Name")
	void search1()
	{
		
		homePageObject.pageValidation(driver);
		
		searchedElements=homePageObject.searchProduct("iMac");
		boolean value=searchedElements.pageValidation(driver);
		Assert.assertTrue(value,"failed to land on searched product");
		
	
	
	
	
	}
	
	
}
