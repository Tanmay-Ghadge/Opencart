package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{

	WebDriver localdriver;
	CommonElements commonElements  ;

	public MyAccountPage(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//a[text()='Subscribe / unsubscribe to newsletter']")
	private WebElement newsLetterBtn;
	
	@FindBy(tagName ="h2")
	private WebElement pageHeading;
	
	
	
/*----------------------------page methods------------------------------*/
	
	
	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="My Account";

		String actualPageHeading=pageHeading.getText();
		String expectedPageHeading="My Account";

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
	
	public NewsLetter clickNewsLetter()
	{
		newsLetterBtn.click();
		return new NewsLetter(localdriver);
	}

	
}
