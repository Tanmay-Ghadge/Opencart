package com.Opencart.Dataprovider;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataproviders 
{
	@DataProvider(name="dataforLogin")
	public static String[][]  dataforLogin()
	{
		String [][] data=new String [][]
				{

			{"lillie.king@example.com","jets"},//valid email valid password
			{"wrong@username.com","wrongpassword"},//invalid username invalid password
			{"wrongusername@example1.com","alpha"},//invalid username valid password
			{"evelyn.duncan@example.com","mavrick"},//valid email invalid password
			{"",""},
				};
				return data;

	}
	

	@DataProvider(name="commonDataProvider")
	public static Object[][] getData2()
	{

		Object[][] dataForupdateCustomerDetails = new Object[][]
				{
			{ "john","stewart","john","qrwerty852",true,false},
			{ "john","stewart","john@","qrwerty852",true,false},
			{ "john","stewart","john@gmail","qrwerty852",true,false},
			{ "john","stewart","john@gmail .com","qrwerty852",true,false},
			{ "john","stewart","john @gmail .com","qrwerty852",true,false},
			{ "john","stewart","john@gmail.com","qrwerty852",true,false},
				};

				return dataForupdateCustomerDetails;
	}
	
	
	@DataProvider(name = "dataforRegistration")
	public static Object[][] getData(Method method,ITestContext test)
	{
		String methodName=method.getName();	
		switch (methodName) 
		{
		case "fillRegistrationDetails1":
			Object[][] data = new Object[][] 
					{ 
			{ "dorthy","nebula","nebula.cecile@gmail.com","651486548",false,true}
					};
		return data;  
		// break;          can we break after return statement

		case "fillRegistrationDetails2":
			Object[][] nodata = new Object[][]
					{ 
					  {	"","","","",false,false}
					};	
			return nodata;

		case "fillRegistrationDetails4":
			Object[][] yesOption = new Object[][] 
					{ 
						{"david","waller","daved@gmail.com" ,"qrwerty852",true,true}
					};	
			return yesOption;

		case "fillRegistrationDetails5":
			Object[][] noOption = new Object[][] 
					{ 
						{"Gunter","Steinbach","Gunter.thiel@wegener.com","656877790",false,true}
					};	
			return noOption;

		case "fillRegistrationDetails7":
			Object[][] spaces = new Object[][] 
					{ 
						{	"    ","      ","      " ,"        ",false,true}
					};
			return spaces;

		case "fillRegistrationDetails8"://noPrivacyPolicy
			return new Object[][] {{"Byron","Ramos","byron.ramos@example.com","1656 ",true,false}};

		case "fillRegistrationDetails6"://duplicatedata
			return new Object[][]{ 	{ "dorthy","nebula","nebula.cecile@gmail.com","651486548",false,true}};
	
		default :
			return new Object[][]{ {"no such method"}};
		}
	}

	@DataProvider(name = "dataforRegistrationX")
	public static Object[] getDatax(Method method,ITestContext test)
	{
		String methodName=method.getName();	
		
		if(methodName.equals("fillRegistrationDetails1"))
		{
			return new Object[] 
					{ 
					"Fiona","Miller","durand.cecile@noos.fr","199630451"
			};
		}
		else
		{
			return new Object[] {"no such method"};
		}
	}

}

//@DataProvider(name="commonDataProvider")


//{data[0][0]="lillie.king@example.com";data[0][1]="jets";};
