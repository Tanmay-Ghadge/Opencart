package com.Opencart.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.actiondriver.ActionDriver;

public class LogIn 
{
	WebDriver localdriver;
	CommonElements commonElements  =new CommonElements(localdriver);

	public LogIn(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueBtn;

	@FindBy(id="input-email")
	private WebElement enterEmailTextbox;
	
	@FindBy(id="input-password")
	private WebElement enterPasswordTextbox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//a[text()='Forgotten Password']")
	private WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//aside[@id='column-right']//a[text()='Register']")
	private WebElement register;
	
/*-----------------------page methods-----------------------------*/
	
	
	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="Account Login";

		if(actualTitle.equals(expectedTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	

	public RegistrationObjects clickoncontinueBtn() 
	{
		continueBtn.click();
		return new RegistrationObjects(localdriver);
		
	}
	
	public ForgotPassword clickonforgetpasswordlink() 
	{
		ForgotPasswordLink.click();
		return new ForgotPassword(localdriver);
		
	}
	public RegistrationObjects clickonmyAccountBtn() 
	{
		myAccount.click();
		return new RegistrationObjects(localdriver);
		
	}
	
	public RegistrationObjects clickonmyregisterBtn() 
	{
		register.click();
		return new RegistrationObjects(localdriver);
		
	}
	
	public String getPlaceholderEmailTextbox()
	{
		String placeholdervalue=enterEmailTextbox.getAttribute("placeholder");
		return placeholdervalue;
	}
	
	public String getPlaceholdPasswordTextbox()
	{
		String placeholdervalue=enterPasswordTextbox.getAttribute("placeholder");
		return placeholdervalue;
	}
	
	
	
	public boolean login(String username,String password) throws InterruptedException
	{
		enterEmailTextbox.sendKeys(username);
		enterPasswordTextbox.sendKeys(password);
		LoginBtn.click();
		Thread.sleep(2000);
		boolean tilte=ActionDriver.getpageTitle(localdriver,"My Account");
		
		if(tilte==true)
		{
		return true; 
		}
		else
		{
			return false;
		}
		
		
	}



	public WebElement getForgotPasswordLink()
	{
		return ForgotPasswordLink;
	}



	public void setForgotPasswordLink(WebElement forgotPasswordLink) 
	{
		ForgotPasswordLink = forgotPasswordLink;
	}
	
	public MyAccountPage loginByKeyBoard(String mail,String pwd) 
	{
		Actions act=new Actions(localdriver);
		ActionDriver.actionClick(enterEmailTextbox);
		act.moveToElement(enterEmailTextbox).click()
		.sendKeys(mail)
		.keyDown(Keys.TAB).keyUp(Keys.TAB)
		.sendKeys(pwd)
		.keyDown(Keys.ENTER).keyUp(Keys.ENTER)
		.build().perform();
		
		return new MyAccountPage(localdriver);

	}
	
	
	
	
}
