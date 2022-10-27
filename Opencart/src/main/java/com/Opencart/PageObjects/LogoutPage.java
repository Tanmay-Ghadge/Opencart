package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.actiondriver.ActionDriver;

public class LogoutPage 
{
	WebDriver localdriver;
	ActionDriver actionDriver=new ActionDriver();
	CommonElements commonElements=new CommonElements(localdriver);
	
	public LogoutPage(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//h1[text()='Account Logout']")
	private  WebElement pageHeading;
	
	@FindBy(xpath="//a[text()='Continue']")
	private  WebElement continuebtn;
	
	
	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="Account Logout";

		String actualPageHeading=pageHeading.getText();
		String expectedPageHeading="Account Logout";

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

	public HomePage logoutContinue()
	{
		continuebtn.click();
		return new HomePage(localdriver);
	}
	
	
	
	
	
	
}


