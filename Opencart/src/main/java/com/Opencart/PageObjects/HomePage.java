package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver localDriver;

	public HomePage(WebDriver rdriver)
	{
		localDriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(id="carousel-banner-1")
	private WebElement logoSides;
	
	@FindBy(xpath="//h3[text()='Featured']")
	private WebElement featured;
	
	@FindBy(xpath="//div[@id='logo']/a")
	private WebElement opencartLogo;
	
	@FindBy(xpath="//a[text()='Account']")
	private WebElement accountBreadcrumb;
	
	

	
	

/*----------------------------page methods------------------------------*/


	public boolean pageValidation(WebDriver driver) 
	{

		String actualTitle=driver.getTitle();
		String expectedTitle="Your Store";

		if(actualTitle.equals(expectedTitle) && logoSides.isDisplayed() && featured.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public void clickOnLogo()
	{
		opencartLogo.click();
		
	}
	
	public LogIn clickOnAccount()
	{
		accountBreadcrumb.click();
		return new LogIn(localDriver);
	}
	
	
}
