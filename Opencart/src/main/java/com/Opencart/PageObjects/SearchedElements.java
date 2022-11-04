package com.Opencart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.actiondriver.ActionDriver;

public class SearchedElements 
{
	WebDriver localdriver;
	ActionDriver actionDriver=new ActionDriver();
	CommonElements commonElements;

	public SearchedElements(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="input-newsletter-yes")
	private WebElement subscribeYes;
	
	
	
	/*----------------------------page methods----------------------------*/
	
		public boolean pageValidation(WebDriver driver)
		{
			String actualTitle=driver.getTitle();
			String expectedTitle="Search";


			if(actualTitle.contains(expectedTitle))
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		
		
	}
	
	

	

