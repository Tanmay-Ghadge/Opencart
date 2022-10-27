package com.Opencart.TestcaseScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.Opencart.PageObjects.MyAccountPage;
import com.Opencart.PageObjects.RegistrationObjects;
import com.Opencart.Utility.Log;

public class LoginTests extends Base 
{
	WebDriver driver;
	HomePage homePageObject=new HomePage(driver);
	RegistrationObjects registrationObjects;
	CommonElements commonElements;
	LogIn loginObject;
	ForgotPassword forgetPasswordObject;
	MyAccountPage myAccountPageObject;
	SoftAssert softAssert=new SoftAssert();

	@BeforeMethod
	void setup() throws IOException
	{
		loadConfiguration();
		driver=selectBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		openURL();

	}

	@Test(description ="Validate logging into the Application using valid credentials", 
			dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
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
		Assert.assertTrue(result1,"with valid mailID and password failed to log in " );
		
	}
	
	@Test(description ="Validate logging into the Application using invalid credentials "
			+ "(i.e. Invalid email address and Invalid Password)", 
			dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void validateLogin2(String mail,String pwd) throws InterruptedException
	{
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Log in Page");

		boolean result2=loginObject.login(mail,pwd);
		Assert.assertFalse(result2,"with invalid mailID and invalid password user logged in" );

	}
	

	@Test(description ="Validate logging into the Application using invalid email address and valid Password)", 
			dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void validateLogin3(String mail,String pwd) throws InterruptedException
	{
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Log in Page");

		boolean result3=loginObject.login(mail,pwd);
		Assert.assertFalse(result3,"with invalid username valid password user logged in " );
	}
	
	@Test(description ="Validate logging into the Application using valid email address and invalid Password)", 
			dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void validateLogin4(String mail,String pwd) throws InterruptedException
	{
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Log in Page");
		
		boolean result4=loginObject.login(mail,pwd);
		Assert.assertFalse(result4,"with valid email invalid password user logged in");	
		
	}
	
	@Test(description ="Validate logging into the Application without providing any credentials", 
			dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void validateLogin5(String mail,String pwd) throws InterruptedException
	{
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Log in Page");
		
		boolean result5=loginObject.login(mail,pwd);
		Assert.assertFalse(result5,"with no credentials user logged in");
		
	}

	

	@Test(description ="Validate 'Forgotten Password' link is available in the Login page and is working")
	void forgotPasswordValidation()
	{

		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		Assert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		Assert.assertTrue(value,"failed to land on Log in Page");

		WebElement forgotPassword=loginObject.getForgotPasswordLink();
		Assert.assertTrue(forgotPassword.isDisplayed(),"forgot password link is not displayed");

		forgetPasswordObject=loginObject.clickonforgetpasswordlink();
		Assert.assertTrue(forgetPasswordObject.pageValidation(driver),"failed to land on forgot passwprd page");
	}

	@Test(description ="Validate E-Mail Address and Password text fields in the Login page have the place holder text")
	void loginPagePlaceholder()
	{

		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		Assert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value=loginObject.pageValidation(driver);
		Assert.assertTrue(value,"failed to land on Log in Page");

		String emailTextboxPlaceholder=loginObject.getPlaceholderEmailTextbox();
		String passwordPlaceholder=loginObject.getPlaceholdPasswordTextbox();

		softAssert.assertEquals(emailTextboxPlaceholder,"E-Mail Address","E-Mail Address placeholder text mismatch");
		softAssert.assertEquals(passwordPlaceholder,"Password","Password placeholder text mismatch");

		softAssert.assertAll();

	}

	@Test(description ="Validate the different ways of navigating to the Login page")
	void validateNavigationToLoginPage()
	{

		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		Assert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);
		//approch 1
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean value=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(value,"failed to land on Registration Page");

		loginObject=registrationObjects.clickloginHyperLink();
		softAssert.assertTrue(loginObject.pageValidation(driver),"failed to navigate to login page by approch 1");

		homePageObject.clickOnLogo();
		//approch 2
		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value2=loginObject.pageValidation(driver);
		softAssert.assertTrue(value2,"failed to navigate to login page by approch 2");

		homePageObject.clickOnLogo();
		//approch 3
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		loginObject=commonElements.clickonRightColumnlogin();
		boolean value3=loginObject.pageValidation(driver);
		softAssert.assertTrue(value3,"failed to navigate to login page by approch 3");

		softAssert.assertAll();
	}

	@Test(description = "Validate logging into the Application using Keyboard keys (Tab and Enter)",
	dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void loginByKeyboard(String mail,String pwd) throws InterruptedException
	{

		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		Assert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value2=loginObject.pageValidation(driver);
		softAssert.assertTrue(value2,"failed to navigate to login page by approch 2");

		myAccountPageObject=loginObject.loginByKeyBoard(mail,pwd);

		boolean value=myAccountPageObject.pageValidation(driver);
		Assert.assertTrue(value,"log in unsuccessful");
		
		softAssert.assertAll();
		
	}
	
	@Test(description ="Validate Logging into the Application and browsing back using Browser back button",
			dataProvider ="dataforLogin",dataProviderClass = Dataproviders.class)
	void login(String mail,String pwd) throws InterruptedException
	{
		Log.startTestCase("5555555555555556155555555551655555555");
        Log.info("6555555555555555546588554661222222222222");
		homePageObject=new HomePage(driver);
		boolean validationHomePage=homePageObject.pageValidation(driver);
		Assert.assertTrue(validationHomePage,"failed to land on Home page");

		commonElements=new CommonElements(driver);

		loginObject=commonElements.selectMyaccountOptionLogin();
		boolean value2=loginObject.pageValidation(driver);
		softAssert.assertTrue(value2,"failed to navigate to login page by approch 2");

		myAccountPageObject=loginObject.loginByKeyBoard("tanmayghadge@gmail.com","tanmay");

		boolean value=myAccountPageObject.pageValidation(driver);
		Thread.sleep(2000);
		Assert.assertTrue(value,"log in unsuccessful");
	
		//websites back button doesnt work
		driver.navigate().back();
		
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		
		boolean value3=myAccountPageObject.pageValidation(driver);
		Assert.assertTrue(value3,"user was not able stay logged in");
	}
}
