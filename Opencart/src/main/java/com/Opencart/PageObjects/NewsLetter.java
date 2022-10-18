package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.actiondriver.ActionDriver;

public class NewsLetter 
{
	WebDriver localdriver;
	ActionDriver actionDriver=new ActionDriver();
	CommonElements commonElements;

	public NewsLetter(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="input-newsletter-yes")
	private WebElement subscribeYes;
	
	@FindBy(id="input-newsletter-no")
	private WebElement subscribeNo;
	
	@FindBy(xpath="//a[text()='Back']")
	private WebElement backBtn;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//h1[text()='Newsletter Subscription']")
	private WebElement pageHeading;
	
	
	
	
/*----------------------------page methods------------------------------*/
	
	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="Newsletter Subscription";
		
		String actualPageHeading=pageHeading.getText();
		String expectedPageHeading="Newsletter Subscription";
		
		String lastBreadcrumb=commonElements.getLastBreadcrumbOption();
		String actualLastBreadcrumb=lastBreadcrumb;
		String expectedLastBreadcrumb="Newsletter";

		if(actualTitle.equals(expectedTitle) && actualPageHeading.equals(expectedPageHeading) && actualLastBreadcrumb.equals(expectedLastBreadcrumb))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean isYesSelected()
	{
		if(subscribeYes.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isNoSelected()
	{
		if(subscribeNo.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
}
