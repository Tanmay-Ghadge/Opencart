package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationSuccess
{
	WebDriver localDriver;
	
	public AccountCreationSuccess(WebDriver rdriver)
	{
		localDriver=rdriver;
	    PageFactory.initElements(rdriver,this );
	}
	
	
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(id="content")
	private WebElement message;
	
	@FindBy(xpath="//a[text()='contact us']")
	private WebElement contactUs;
	
	
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement pageHeading;
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li[last()]")
	private  WebElement lastBreadcrumb;
	
	
/*----------------------------page methods------------------------------*/
	
	public boolean pageValidation(WebDriver driver)
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="Your Account Has Been Created!";
		
		String actualPageHeading=pageHeading.getText();
		String expectedPageHeading ="Your Account Has Been Created!";
		
		String actualLastBreadcrumb=lastBreadcrumb.getText();
		String expectedLastBreadcrumb="Your Account Has Been Created!";
		
		if(actualTitle.equals(expectedTitle) && actualPageHeading.equals(expectedPageHeading) && actualLastBreadcrumb.equals(expectedLastBreadcrumb))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String getSuccessmessage()
	{
		String actualMessage=message.getText();
		return actualMessage;
	}
	
	public MyAccountPage clickContinue()
	{
		continueBtn.click();
		return new MyAccountPage(localDriver);
	}
	
	
}
	


