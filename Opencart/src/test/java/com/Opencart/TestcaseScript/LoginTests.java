package com.Opencart.TestcaseScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.Opencart.PageObjects.RegistrationObjects;

public class LoginTests extends Base 
{
	WebDriver driver;
	HomePage homePageObject=new HomePage(driver);
	RegistrationObjects registrationObjects;
	CommonElements commonElements;
	LogIn loginObject;
	ForgotPassword forgetPasswordObject;
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

}
