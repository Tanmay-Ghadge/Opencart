package com.Opencart.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Opencart.actiondriver.ActionDriver;

public class CommonElements 
{
	WebDriver localdriver;
	
	public CommonElements(WebDriver rdriver)  // which access modifier should a constructor have 
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Top header
	@FindBy(className="breadcrumb")
	private List <WebElement> breadcrumbsUL;
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li[last()]")
	private  WebElement lastBreadcrumb;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a")
	private List <WebElement> myaccountUL;

	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[1]/span")
	private WebElement phone;
	
	@FindBy(xpath="//*[@id=\"wishlist-total\"]/span")
	private WebElement wishList;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[4]/a/span")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[5]/a/span")
	private WebElement checkout;
	
	//Blue navbar
	@FindBy(xpath="//a[text()='Desktops']")
	private WebElement desktops;
	
	@FindBy(xpath="//a[text()='Laptops & Notebooks']")
	private WebElement LaptopsNotebooks;
	
	@FindBy(xpath="//a[text()='Components']")
	private WebElement Components;
	
	@FindBy(xpath="//a[text()='Tablets']")
	private WebElement Tablets;
	
	@FindBy(xpath="//a[text()='Software']")
	private WebElement Software;
	
	@FindBy(xpath="//a[text()='Phones & PDAs']")
	private WebElement PhonesPDAs;
	
	@FindBy(xpath="//a[text()='Cameras']")
	private WebElement cameras;
	
	@FindBy(xpath="//a[text()='MP3 Players']")
	private WebElement MP3Players;
	
	//Right column navbar
	
	@FindBy(xpath="//a[text()='//aside[@id='column-right']/div/a']")
	private List<WebElement> rightCoulumsOptions;
	
	@FindBy(xpath="//aside[@id='column-right']//a[text()='Register']")
	private WebElement register;
	
	@FindBy(xpath="//aside[@id='column-right']//a[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath="//aside[@id='column-right']//a[text()='My Account']")
	private WebElement myAccount;
	
	
	void clickonMyAccountRight()
	{
		myAccount.click();
	}
	
	public LogIn clickonRightColumnlogin()
	{
		login.click();
		return new LogIn(localdriver);
	}
	
	
	
	
	
	/*bradcrumbs
	login
	MyAccount
	contact,customer services
	header currency
	WishList*/

	
	/*------------*/
	//choose breadcrumbOption
	
	public RegistrationObjects selectMyaccountOptionRegister()
	{
		myAccountDropdown.click();
		ActionDriver.dropdownUL(myaccountUL, "Register");
		return new RegistrationObjects(localdriver);
	}
	
	public LogIn selectMyaccountOptionLogin()
	{
		myAccountDropdown.click();
		System.out.println("clicked on my account");
		ActionDriver.dropdownUL(myaccountUL,"Login");
		return new LogIn(localdriver);
	}

 	public void chooseBreadcrumbOption(String option)
	{
		ActionDriver.dropdownUL(breadcrumbsUL, option);
	}

    public String getLastBreadcrumbOption()
    {
    	String lastBreadcrumbName=lastBreadcrumb.getText();
    	System.out.println(lastBreadcrumbName);
    	return lastBreadcrumbName;
    }

    public RegistrationObjects clickRegisterOption()
    {
    	register.click();
    	return new RegistrationObjects(localdriver);
    }


}
