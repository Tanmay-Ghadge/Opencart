package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.actiondriver.ActionDriver;

public class ForgotPassword 
{
	WebDriver localdriver;
	ActionDriver actionDriver=new ActionDriver();
	CommonElements commonElements=new CommonElements(localdriver);
	
	public ForgotPassword(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="input-email")
	private WebElement emailId;
	
	
	
	
/*--------------------------page methods--------------------------*/
	
	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="Forgot Your Password?";

		if(actualTitle.equals(expectedTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
