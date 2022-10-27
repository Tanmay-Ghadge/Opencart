package com.Opencart.Dataprovider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.Opencart.Utility.ExcelLibrary;

public class Dataproviders 
{ 

	@DataProvider(name = "dataforRegistration")
	public static Object[][] getData1(Method method,ITestContext test) throws IOException
	{
		ExcelLibrary readExcel=new ExcelLibrary();
		String path="C:\\Users\\tusha\\git\\repository\\Opencart\\src\\test\\resources\\Test Data\\TestData.xlsx";

		String methodName=method.getName();	
		switch (methodName) 
		{
		case "createUsers":
			Object[][] userdata = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"CreateUsers",1,0),readExcel.getCellValue(path,"CreateUsers",1,1),readExcel.getCellValue(path,"CreateUsers",1,2),  readExcel.getCellValue(path,"CreateUsers",1,3), readExcel.getCellValue(path,"CreateUsers",1,4), readExcel.getCellValue(path,"CreateUsers",1,5)}, 
				{readExcel.getCellValue(path,"CreateUsers",2,0),readExcel.getCellValue(path,"CreateUsers",2,1),readExcel.getCellValue(path,"CreateUsers",2,2),  readExcel.getCellValue(path,"CreateUsers",2,3), readExcel.getCellValue(path,"CreateUsers",2,4), readExcel.getCellValue(path,"CreateUsers",2,5)}, 
				{readExcel.getCellValue(path,"CreateUsers",3,0),readExcel.getCellValue(path,"CreateUsers",3,1),readExcel.getCellValue(path,"CreateUsers",3,2),  readExcel.getCellValue(path,"CreateUsers",3,3), readExcel.getCellValue(path,"CreateUsers",3,4), readExcel.getCellValue(path,"CreateUsers",3,5)}, 
				{readExcel.getCellValue(path,"CreateUsers",4,0),readExcel.getCellValue(path,"CreateUsers",4,1),readExcel.getCellValue(path,"CreateUsers",4,2),  readExcel.getCellValue(path,"CreateUsers",4,3), readExcel.getCellValue(path,"CreateUsers",4,4), readExcel.getCellValue(path,"CreateUsers",4,5)}, 
				{readExcel.getCellValue(path,"CreateUsers",5,0),readExcel.getCellValue(path,"CreateUsers",5,1),readExcel.getCellValue(path,"CreateUsers",5,2),  readExcel.getCellValue(path,"CreateUsers",5,3), readExcel.getCellValue(path,"CreateUsers",5,4), readExcel.getCellValue(path,"CreateUsers",5,5)}, 
					};
					return userdata; 

		case "fillRegistrationDetails1":
			Object[][] data = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Registration",1,0),  //first name
					readExcel.getCellValue(path,"Registration",1,1),  //last name
					readExcel.getCellValue(path,"Registration",1,2),  // email id 
					readExcel.getCellValue(path,"Registration",1,3),  //password
					readExcel.getCellValue(path,"Registration",1,4),  //newsletter
					readExcel.getCellValue(path,"Registration",1,5)}, //privacy policy checkmark
					};
					return data;  
					// break;          can we break after return statement

		case "fillRegistrationDetails2":
			Object[][] nodata = new Object[][]
					{ 
				{readExcel.getCellValue(path,"Registration",2,0),
					readExcel.getCellValue(path,"Registration",2,1),
					readExcel.getCellValue(path,"Registration",2,2),
					readExcel.getCellValue(path,"Registration",2,3),
					readExcel.getCellValue(path,"Registration",2,4),
					readExcel.getCellValue(path,"Registration",2,5)},
					};	
					return nodata;

		case "fillRegistrationDetails4":
			Object[][] yesOption = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Registration",3,0),
					readExcel.getCellValue(path,"Registration",3,1),
					readExcel.getCellValue(path,"Registration",3,2),
					readExcel.getCellValue(path,"Registration",3,3),
					readExcel.getCellValue(path,"Registration",3,4),
					readExcel.getCellValue(path,"Registration",3,5)},
					};	
					return yesOption;

		case "fillRegistrationDetails5":
			Object[][] noOption = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Registration",4,0),
					readExcel.getCellValue(path,"Registration",4,1),
					readExcel.getCellValue(path,"Registration",4,2),
					readExcel.getCellValue(path,"Registration",4,3),
					readExcel.getCellValue(path,"Registration",4,4),
					readExcel.getCellValue(path,"Registration",4,5)},
					};	
					return noOption;

		case "fillRegistrationDetails7":
			Object[][] spaces = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Registration",5,0),
					readExcel.getCellValue(path,"Registration",5,1),
					readExcel.getCellValue(path,"Registration",5,2),
					readExcel.getCellValue(path,"Registration",5,3),
					readExcel.getCellValue(path,"Registration",5,4),
					readExcel.getCellValue(path,"Registration",5,5)},
					};
					return spaces;

		case "fillRegistrationDetails8"://noPrivacyPolicy
			return new Object[][]
					{
				{readExcel.getCellValue(path,"Registration",6,0),
					readExcel.getCellValue(path,"Registration",6,1),
					readExcel.getCellValue(path,"Registration",6,2),
					readExcel.getCellValue(path,"Registration",6,3),
					readExcel.getCellValue(path,"Registration",6,4),
					readExcel.getCellValue(path,"Registration",6,5)},
					};

		case "fillRegistrationDetails6"://duplicatedata
			return new Object[][]
					{
				{readExcel.getCellValue(path,"Registration",7,0),
					readExcel.getCellValue(path,"Registration",7,1),
					readExcel.getCellValue(path,"Registration",7,2),
					readExcel.getCellValue(path,"Registration",7,3),
					readExcel.getCellValue(path,"Registration",7,4),
					readExcel.getCellValue(path,"Registration",7,5)},
					};	
		default :
			return new Object[][]{ {"no such method"}};
		}
	}

	@DataProvider(name ="dataforLogin" )
	public static Object[][] getLogindata(Method method,ITestContext test) throws IOException
	{
		ExcelLibrary readExcel=new ExcelLibrary();
		String path="C:\\Users\\tusha\\git\\repository\\Opencart\\src\\test\\resources\\Test Data\\TestData.xlsx";

		String methodName=method.getName();	
		switch (methodName) 
		{
		case "validateLogin":
			Object[][] data = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Log in",1,0),  //valid username
				 readExcel.getCellValue(path,"Log in",1,1) }//valid password
					};
					return data;  
					// break;          can we break after return statement

		case "validateLogin2":
			Object[][] data2 = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Log in",2,0),  //invalid username
					readExcel.getCellValue(path,"Log in",2,1) }//invalid password
					};
					return data2;  

		case "validateLogin3":
			Object[][] data3 = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Log in",3,0),  //valid username
					readExcel.getCellValue(path,"Log in",3,1) }//invalid password
					};
					return data3;  

		case "validateLogin4":
			Object[][] data4 = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Log in",4,0),  //invalid username
					readExcel.getCellValue(path,"Log in",4,1) }//valid password
					};
					return data4;  

		case "validateLogin5":
			Object[][] emptydata = new Object[][] 
					{ 
				{readExcel.getCellValue(path,"Log in",5,0),  //empty username
					readExcel.getCellValue(path,"Log in",5,1) }//empty password
					};
					return emptydata;  

		default :
			return new Object[][]{ {"no such method"}};
		}
	}

}