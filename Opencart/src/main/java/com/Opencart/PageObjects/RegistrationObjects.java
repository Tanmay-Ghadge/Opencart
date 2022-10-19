package com.Opencart.PageObjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.Base.Base;
import com.Opencart.actiondriver.ActionDriver;

public class RegistrationObjects 
{
	WebDriver localdriver;
	ActionDriver actionDriver=new ActionDriver();
	CommonElements commonElements=new CommonElements(localdriver);
	
	public RegistrationObjects(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="input-firstname")
	private WebElement firstname;

	@FindBy(id="error-firstname")
	private WebElement errorFirstname;

	@FindBy(id="input-lastname")
	private WebElement lastname;

	@FindBy(id="error-lastname")
	private WebElement errorLastname;

	@FindBy(id="input-email")
	private WebElement email;

	@FindBy(id="error-email")
	private WebElement errorEmail;

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(id="error-password")
	private WebElement errorPassword;


	@FindBy(id="input-newsletter-yes")
	private WebElement newsletterYesRDO;

	@FindBy(id="input-newsletter-no")
	private WebElement newsletterNoRDO;

	@FindBy(name="agree")
	private WebElement PrivacyPolicyagreeCHK;

	@FindBy(css ="div.container:nth-child(2) div.row div.col form:nth-child(3) div.d-inline-block.pt-2.pd-2.w-100:nth-child(4) div.float-end.text-right > button.btn.btn-primary")
	private WebElement continueBTN;

	@FindBy(xpath="//a[text()='login page']")
	private WebElement loginHyperLink;

	@FindBy(xpath="//h1[text()='Register Account']")
	private  WebElement pageHeading;





	/*----------------------------page methods------------------------------*/

	public void enterFirstName(String firstName)
	{

		firstname.sendKeys(firstName);
		actionDriver.scrollByDistance(localdriver, 0, 500);
	}

	public WebElement getName()
	{
		return firstname;
	}
	
	public WebElement getEmail() 
	{
		return email;
	}


	public void enterLastName(String lastName)
	{
		lastname.sendKeys(lastName);
	}

	public void enterEmail(String emailId)
	{
		email.sendKeys(emailId);
	}

	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void selectNewsletter(boolean condition)
	{
		if(condition==true)
			newsletterYesRDO.click();
		else
			newsletterNoRDO.click();	
	}

	public void acceptPrivacyPolicy(boolean condition)
	{
		if(condition==true)
			PrivacyPolicyagreeCHK.click();
	}

	public AccountCreationSuccess submit() throws InterruptedException  {
		actionDriver.scrollByDistance(localdriver, 0,700);
		Thread.sleep(3000);
		continueBTN.click();
		System.out.println("clicked on submit");
		return new AccountCreationSuccess(localdriver);	
	}

	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="Register Account";

		String actualPageHeading=pageHeading.getText();
		String expectedPageHeading="Register Account";

//		String lastBreadcrumb=commonElements.getLastBreadcrumbOption();
//		String actualLastBreadcrumb=lastBreadcrumb;

		if(actualTitle.equals(expectedTitle) && actualPageHeading.equals(expectedPageHeading))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public boolean validateFirstNameErrorMessage(String error)
	{
		String firstNameError=errorFirstname.getText();
		
		if (firstNameError.equals(error))
			return true;
		else
			return false;
	}
	
	public boolean validateLastNameErrorMessage(String error)
	{
		String lastNameError=errorLastname.getText();
		
		if (lastNameError.equals(error))
			return true;
		else
			return false;
		
	}
	
	public boolean validateEmailErrorMessage(String error)
	{
		String emailError=errorEmail.getText();
		if (emailError.equals(error))
			return true;
		else
			return false;
		
	}
	
	public boolean validatePasswordErrorMessage(String error)
	{
		String passwordError=errorPassword.getText();	
		if (passwordError.equals(error))
			return true;
		else
			return false;
	}
	
	public String getPlaceholderFirstname()
	{
		String placeholdervalue=firstname.getAttribute("placeholder");
		return placeholdervalue;
	}

	public String getPlaceholderPassword()
	{
		String placeholdervalue=password.getAttribute("placeholder");
		return placeholdervalue;
	}
	
	public String getPlaceholderLastname()
	{
		String placeholdervalue=lastname.getAttribute("placeholder");
		return placeholdervalue;
	}
	
	public String getPlaceholderEmailname()

	{
		String placeholdervalue=email.getAttribute("placeholder");
		return placeholdervalue;
	}
	
	public String[] getFirstnameCssValue()
	{
		String content=firstname.getCssValue("content");
		String colour=firstname.getCssValue("color");
		
		String[] cssvalues = new String[] 
		{content,colour};
		
		return cssvalues;
	//	String expectedBorder="1px solid rgb(240, 40, 73)";
	}
	
	public String[] getLastnameCssValue()
	{
		String content=lastname.getCssValue("content");
		String colour=lastname.getCssValue("color");
		
		String[] cssvalues = new String[] 
		{content,colour};
		
		return cssvalues;
	//	String expectedBorder="1px solid rgb(240, 40, 73)";
	}
	
	public String[] getEmailCssValue()
	{
		String content=email.getCssValue("content");
		String colour=email.getCssValue("color");
		
		String[] cssvalues = new String[] 
		{content,colour};
		
		return cssvalues;
	//	String expectedBorder="1px solid rgb(240, 40, 73)";
	}
	
	public String[] getPasswordCssValue()
	{
		String content=password.getCssValue("content");
		String colour=password.getCssValue("color");
		
		String[] cssvalues = new String[] 
		{content,colour};
		
		return cssvalues;
	//	String expectedBorder="1px solid rgb(240, 40, 73)";
	}
	
	public String[] getPrivacyPolicyCssValue()
	{
		String content=PrivacyPolicyagreeCHK.getCssValue("content");
		String colour=PrivacyPolicyagreeCHK.getCssValue("color");
		
		String[] cssvalues = new String[] 
		{content,colour};
		
		return cssvalues;
	//	String expectedBorder="1px solid rgb(240, 40, 73)";
	}
	
	public boolean isSelctedPrivacyPolicyagreeCHK()
	{
		boolean checkbox=PrivacyPolicyagreeCHK.isSelected();
		
		return checkbox;
	}
	 
	public LogIn clickloginHyperLink()
	{
		loginHyperLink.click();
		return new LogIn(localdriver);
	}
	
}

