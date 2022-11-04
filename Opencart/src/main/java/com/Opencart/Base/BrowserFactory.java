package com.Opencart.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
	WebDriver driver=null;

	public WebDriver selectBrowser(String browserName) throws IOException 
	{

		switch (browserName.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			WebDriverManager.edgedriver().setup();
			FirefoxOptions firefoxoptions=new FirefoxOptions();
			firefoxoptions.addArguments("-private");
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.firefoxdriver().setup();
			EdgeOptions edgeoptions=new EdgeOptions();
			edgeoptions.addArguments("-private");
			driver = new EdgeDriver(edgeoptions);
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ieOptions=new InternetExplorerOptions();
			ieOptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(ieOptions);
			break;



		default:
			System.err.println("please enter valid browser name ");
		}
		return driver;

	}

}
