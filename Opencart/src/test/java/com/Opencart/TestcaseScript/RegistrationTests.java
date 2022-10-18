package com.Opencart.TestcaseScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Opencart.Base.Base;
import com.Opencart.Dataprovider.Dataproviders;
import com.Opencart.PageObjects.AccountCreationSuccess;
import com.Opencart.PageObjects.CommonElements;
import com.Opencart.PageObjects.HomePage;
import com.Opencart.PageObjects.LogIn;
import com.Opencart.PageObjects.MyAccountPage;
import com.Opencart.PageObjects.NewsLetter;
import com.Opencart.PageObjects.RegistrationObjects;


public class RegistrationTests extends Base
{
	WebDriver driver;
	
	CommonElements commonElements;//how to follow page chaining model
	HomePage homePageObject;//How to initialise the objects homePageObject and commonElements when no method returns them
	RegistrationObjects registrationObjects;
	AccountCreationSuccess accountCreationSuccessObject;
	MyAccountPage myAccountPage;
	NewsLetter newsLetterObject;
	LogIn loginObject;

	SoftAssert softAssert=new SoftAssert();


	@BeforeMethod
	void setup() throws IOException
	{
		loadConfiguration();
		driver=selectBrowser("chrome");
		homePageObject=openURL();

	} 


	@Test(description="Validate Registering an Account by providing only the Mandatory fields",
	priority = 8,dataProvider ="dataforRegistration",dataProviderClass = Dataproviders.class)
	
	 void fillRegistrationDetails1(Object [] a ) throws InterruptedException
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landd on HomePage");
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");

		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		accountCreationSuccessObject=registrationObjects.submit();
		accountCreationSuccessObject=new AccountCreationSuccess(driver);

		boolean registrationSuccessful=accountCreationSuccessObject.pageValidation(driver);
		softAssert.assertTrue(registrationSuccessful, "successfully registered");

		String actualMessage=accountCreationSuccessObject.getSuccessmessage();
		String expectedMessage="Congratulations! Your new account has been successfully created!\r\n"
				+ "\r\n"
				+ "You can now take advantage of member privileges to enhance your online shopping experience with us.\r\n"
				+ "\r\n"
				+ "If you have ANY questions about the operation of this online shop, please e-mail the store owner.\r\n"
				+ "\r\n"
				+ "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

		softAssert.assertEquals(actualMessage, expectedMessage, "correct message is shown");

		softAssert.assertAll();
	}

	@Test(description = "Validate proper notification messages are displayed for the mandatory fields, "
			+ "when you don't provide any fields in the 'Register Account' page and submit", 
			priority = 9)
	void fillRegistrationDetails3() throws InterruptedException 
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		Assert.assertTrue(validationHomePage,"successfully landed on HomePage");
		
		commonElements=new CommonElements(driver);
		
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");


		registrationObjects.submit();
		
		String firstNameerror="First Name must be between 1 and 32 characters!";
		String lastNameerror="Last Name must be between 1 and 32 characters!";
		String emailerror="E-Mail Address does not appear to be valid!";
		String passwordError="Password must be between 4 and 20 characters!";

		boolean firstnameErrorValidation =registrationObjects.validateFirstNameErrorMessage(firstNameerror);
		softAssert.assertTrue(firstnameErrorValidation,"correct message is shown for first name");

		boolean lastnameErrorValidation =registrationObjects.validateLastNameErrorMessage(lastNameerror);
		softAssert.assertTrue(lastnameErrorValidation,"correct message is shown for last name");

		boolean emailErrorValidation =registrationObjects.validateEmailErrorMessage(emailerror);
		softAssert.assertTrue(emailErrorValidation,"correct message is shown for email");

		boolean passwordErrorValidation =registrationObjects.validatePasswordErrorMessage(passwordError);
		softAssert.assertTrue(passwordErrorValidation,"correct message is shown for password");

		softAssert.assertAll();
		//How to validate privacy policy error
	}

	@Test(description="Validate Registering an Account when 'Yes' option is selected for Newsletter field",
			priority = 10,dataProvider ="dataforRegistration",dataProviderClass = Dataproviders.class)
	void fillRegistrationDetails4(Object [] a) throws InterruptedException
	{

		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landd on HomePage");
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");
		
		
		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		accountCreationSuccessObject=registrationObjects.submit();

		myAccountPage=accountCreationSuccessObject.clickContinue();
		newsLetterObject=myAccountPage.clickNewsLetter();
		
		boolean yes=newsLetterObject.isYesSelected();
		softAssert.assertTrue(yes,"yes is not selected");
		
		softAssert.assertAll();
	}

	@Test(description="//Validate Registering an Account when 'No' option is selected for Newsletter field",
			priority = 11,dataProvider ="dataforRegistration",dataProviderClass = Dataproviders.class)
	void fillRegistrationDetails5(Object [] a) throws InterruptedException
	{

		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landd on HomePage");
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");
	

		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		accountCreationSuccessObject=registrationObjects.submit();

		myAccountPage=accountCreationSuccessObject.clickContinue();
		newsLetterObject=myAccountPage.clickNewsLetter();
		
		boolean no=newsLetterObject.isNoSelected();
		softAssert.assertTrue(no,"no is not selected");
		
		softAssert.assertAll();
	}

	@Test(description ="Validate different ways of navigating to 'Register Account' page",priority = 2)
	void validateAllNavigationToRegistrationPage1()
	{
		
		commonElements=new CommonElements(driver);
		
		//approch 1
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landd on HomePage");
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");
		
		
		homePageObject.clickOnLogo();
		
		//approch 2
		loginObject=commonElements.selectMyaccountOptionLogin();
		if(loginObject.pageValidation(driver))
		{
			registrationObjects=loginObject.clickoncontinueBtn();
			boolean navigation2=registrationObjects.pageValidation(driver);
			softAssert.assertTrue(navigation2,"navigation from log in page to Registration failed");
		}
		else
		{
			Assert.fail("did not navigated to login page");
		}

		homePageObject.clickOnLogo();
		//approch 3
		loginObject=commonElements.selectMyaccountOptionLogin();
		if(loginObject.pageValidation(driver))
		{
			registrationObjects=loginObject.clickonmyregisterBtn();
			boolean navigation2=registrationObjects.pageValidation(driver);
			softAssert.assertTrue(navigation2,"navigation from log in page to Registration failed");
		}
		else
		{
			Assert.fail("did not navigated to login page");
		}	
		softAssert.assertAll();
	}

	@Test(description = "Validate Registering an Account by providing the existing account details (i.e. existing email address)",
			priority = 1,dataProvider ="dataforRegistration",dataProviderClass = Dataproviders.class)
	void fillRegistrationDetails6(Object [] a) throws InterruptedException
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landd on HomePage");
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");

		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		accountCreationSuccessObject=registrationObjects.submit();
		
		//how to validate with undetectable error message in dom
		String expectederrormessage="";
		softAssert.assertAll();
	}

	@Test(description ="Validate all the fields in the Register Account page have the proper placeholders",priority = 3)
	void validatePlaceholders()
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landed on HomePage");
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");

		String firstNamePlaceholder=registrationObjects.getPlaceholderFirstname();
		String lastNamePlaceholder=registrationObjects.getPlaceholderLastname();
		String emailPlaceholder=registrationObjects.getPlaceholderEmailname();
		String passwordPlaceholder=registrationObjects.getPlaceholderPassword();

		softAssert.assertEquals(firstNamePlaceholder, "First Name","placeholder for field First name is incorrect");
		softAssert.assertEquals(lastNamePlaceholder, "Last Name","placeholder for field Last name is incorrect");
		softAssert.assertEquals(emailPlaceholder, "E-Mail","placeholder for field Email is incorrect");
		softAssert.assertEquals(passwordPlaceholder, "Password","placeholder for field Password is incorrect");
		softAssert.assertAll();
	}

	@Test(description ="Validate mandatory fields have * sign",priority = 4)
	void validateMandatoryFields()
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landed on HomePage");
		
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");
		
		String[] cssValuesFirst=registrationObjects.getFirstnameCssValue();
		softAssert.assertEquals(cssValuesFirst[0],"* ", "* symbol is not visible for first name field");
		
		String[] cssValuesLastName=	registrationObjects.getLastnameCssValue();
		softAssert.assertEquals(cssValuesLastName[0],"* ", "* symbol is not visible for last name field");
		
		String[] cssValuesEmail=registrationObjects.getEmailCssValue();
		softAssert.assertEquals(cssValuesEmail[0],"* ", "* symbol is not visible for email field");
		
		String[] cssValuesPassword=registrationObjects.getPasswordCssValue();
		softAssert.assertEquals(cssValuesPassword[0],"* ", "* symbol is not visible for password field");
		
		String[] cssValuesPrivacyPolicy=registrationObjects.getPrivacyPolicyCssValue();
		softAssert.assertEquals(cssValuesPrivacyPolicy[0],"* ", "* symbol is not visible for privacy policy field");
		
		softAssert.assertAll();
		
				
	}

	@Test(description ="Validate whether the Mandatory fields in the Register Account page are accepting only spaces",
		priority = 5,dataProvider ="dataforRegistration",dataProviderClass = Dataproviders.class	)
	void fillRegistrationDetails7(Object [] a) throws InterruptedException
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landed on HomePage");
		
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");

		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		registrationObjects.submit();

		registrationObjects=commonElements.selectMyaccountOptionRegister();
		registrationObjects.submit();
		Thread.sleep(3000);
		
		String firstNameerror="First Name must be between 1 and 32 characters!";
		String lastNameerror="Last Name must be between 1 and 32 characters!";
		String emailerror="E-Mail Address does not appear to be valid!";
		String passwordError="Password must be between 4 and 20 characters!";

		boolean firstnameErrorValidation =registrationObjects.validateFirstNameErrorMessage(firstNameerror);
		softAssert.assertTrue(firstnameErrorValidation,"correct message is shown for first name");

		boolean lastnameErrorValidation =registrationObjects.validateLastNameErrorMessage(lastNameerror);
		softAssert.assertTrue(lastnameErrorValidation,"correct message is shown for last name");

		boolean emailErrorValidation =registrationObjects.validateEmailErrorMessage(emailerror);
		softAssert.assertTrue(emailErrorValidation,"correct message is shown for email");

		boolean passwordErrorValidation =registrationObjects.validatePasswordErrorMessage(passwordError);
		softAssert.assertTrue(passwordErrorValidation,"correct message is shown for password");

		softAssert.assertAll();
	}

	
	@Test(description ="Validate whether the 'Privacy Policy' checkbox option is not selected by default",priority = 6)
	void validatePrivacyPolicyBtn() throws InterruptedException
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landed on HomePage");
		
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");
		
		boolean value=registrationObjects.isSelctedPrivacyPolicyagreeCHK();
		
		Assert.assertTrue(value, "privacy policy checkbox is selected by default");

	}

	@Test(description="Validate Registering the Account without selecting the 'Privacy Policy' checkbox option",
	priority = 7,dataProvider ="dataforRegistration",dataProviderClass = Dataproviders.class)
	void fillRegistrationDetails8(Object [] a) throws InterruptedException
	{

		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landed on HomePage");
		
		commonElements=new CommonElements(driver);
		registrationObjects=commonElements.selectMyaccountOptionRegister();
		boolean validationRegistration=registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationRegistration,"successfully landed on RegistrationPage");

		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		registrationObjects.submit();

		registrationObjects=commonElements.selectMyaccountOptionRegister();
		registrationObjects.submit();


		//how to validate privacy policy error
	}
	
	@Test(description="Validate My account field before logging in",
			priority = 13,dataProvider ="testDataRegistration",dataProviderClass = Dataproviders.class)
	void validateMyAccount(Object [] a) throws InterruptedException
	{
		boolean validationHomePage=homePageObject.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landed on HomePage");

		registrationObjects=commonElements.selectMyaccountOptionRegister();
		registrationObjects.pageValidation(driver);
		softAssert.assertTrue(validationHomePage,"successfully landd on RegistrationPage");

		//how to validate privacy policy error
	}


	void fillRegistrationDetailsdUPLICATE(Object [] a ) throws InterruptedException
	{
		registrationObjects.enterFirstName(a[0].toString());
		registrationObjects.enterLastName(a[1].toString());
		registrationObjects.enterEmail(a[2].toString());
		registrationObjects.enterpassword(a[3].toString());
		registrationObjects.selectNewsletter((boolean)a[4]);
		registrationObjects.acceptPrivacyPolicy((boolean)a[5]);
		AccountCreationSuccess accountCreationSuccessObjects=registrationObjects.submit();

		boolean registrationSuccessful=accountCreationSuccessObjects.pageValidation(driver);
		softAssert.assertTrue(registrationSuccessful, "successfully registered");
	} 
	

}
