package com.Opencart.TestcaseScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Opencart.Base.Base;
import com.Opencart.Dataprovider.Dataproviders;
import com.Opencart.PageObjects.CommonElements;
import com.Opencart.PageObjects.HomePage;
import com.Opencart.PageObjects.LogIn;
import com.Opencart.PageObjects.RegistrationObjects;

public class LoginTests extends Base 
{
	WebDriver driver;
	HomePage homePageObject=new HomePage(driver);
	RegistrationObjects registrationObjects;
	CommonElements commonElements;
	LogIn loginObject;
	SoftAssert softAssert=new SoftAssert();
	
	
	
	
	@BeforeMethod
	void setup() throws IOException
	{
		loadConfiguration();
		driver=selectBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		openURL();

	}
	
	@Test(dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void validateLogin(String mail,String pwd) throws InterruptedException
	{
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);
		
		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Log in Page");
		
		boolean result1=loginObject.login(mail,pwd);
		Assert.assertTrue(result1,"with valid mailID and password log in failed" );
		
		/*boolean result2=loginObject.login(a[1][0],a[1][1]);
		Assert.assertFalse(result2,"with invalid mailID and invalid password user logged in" );
		
		boolean result3=loginObject.login(a[2][0],a[2][1]);
		Assert.assertFalse(result3,"with invalid username valid password user logged in " );
		
		boolean result4=loginObject.login(a[3][0],a[3][1]);
		Assert.assertFalse(result4,"with valid email invalid password user logged in");
		
		boolean result5=loginObject.login(a[4][0],a[4][1]);
		Assert.assertFalse(result5,"with no credentials user logged in");
		*/
		
		
		
		
		
	}
	
	
}
