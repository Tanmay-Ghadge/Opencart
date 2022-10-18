package com.Opencart.actiondriver;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionDriver 
{
	public static WebDriver driver;

	public static boolean getpageTitle(WebDriver driver,String expectedTitle)
	{
		String actualPageTitle=driver.getTitle();
		if(actualPageTitle.equals(expectedTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean dropdownSelectByValue(WebElement locationOfDropdown,String value)
	{
		boolean flag = false;
		try 
		{
			Select dropdown=new Select(locationOfDropdown);
			dropdown.selectByValue(value);
			flag = true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown Option-"+value+" was chosen by value");
			}
			else
			{
				System.out.println("dropdown Option-"+value+" was NOT chosen by value");
			}
		}

	}

	public static boolean dropdownSelectByIndex(WebElement locationOfDropdown,int index)
	{
		boolean flag = false;
		try 
		{
			Select dropdown=new Select(locationOfDropdown);
			dropdown.selectByIndex(index);
			flag = true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown index-"+index+" was chosen by index");
			}
			else
			{
				System.out.println("dropdown index-"+index+" was NOT chosen by value");
			}
		}

	}

	public static boolean dropdownSelectByvisibleText(WebElement locationOfDropdown,String visibleText)
	{
		boolean flag = false;
		try 
		{
			Select dropdown=new Select(locationOfDropdown);
			dropdown.selectByVisibleText(visibleText);
			flag = true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown Option-"+visibleText+" was chosen by visibleText");
			}
			else
			{
				System.out.println("dropdown Option-"+visibleText+" was NOT chosen by visibleText");
			}
		}

	}

	public static boolean dropdownUL(List<WebElement> listOfOptions,String optionToChoose)
	{
		boolean flag=false;
		try
		{
			for (WebElement eachoption : listOfOptions) 
			{
				String option=eachoption.getText();
				if(option.equals(optionToChoose))
				{
					eachoption.click();
					flag=true;
					return flag;
				}
			}
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
				System.out.println("dropdown Option-"+optionToChoose+" was  chosen by li option");
			else
				System.out.println("dropdown Option-"+optionToChoose+" was NOT chosen by li option");
		}
		return flag;
	}

	public static boolean dropdownoptions(WebElement location,String optionToChoose)
	{
		boolean flag=false;
		try
		{
			Select dropdown=new Select(location);
			List <WebElement> allOptions=dropdown.getOptions();

			for( WebElement  options:allOptions)
			{			
				if(options.getText().equals(optionToChoose))
				{
					options.click();
					flag=true;
				}			
				break;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag==true)
			{
				System.out.println("dropdown Option-"+optionToChoose+" was chosen by li option");
			}
			else
			{
				System.out.println("dropdown Option-"+optionToChoose+" was NOT chosen by li option");
			}

		}
		return flag;


	}

	public static boolean actionClick(WebElement elementToClick)
	{
		boolean flag=false;
		try 
		{
			Actions act = new Actions(driver);
			act.moveToElement(elementToClick).click().build().perform();
			flag=true;
		}
		catch(Exception e)
		{
			return false;
		}
		return flag;

	}

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void scrollByDistance(WebDriver driver,int horizontalDistance,int verticalDistance)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("window.scrollBy("+horizontalDistance+","+verticalDistance+")"+","+"\"\"");

	}

	public boolean type(WebElement element, String text)
	{
		boolean flag = false;
		try 
		{
			flag = element.isDisplayed();
			element.clear();
			element.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) 
		{
			System.out.println("Location Not found");
			return false;
		} finally
		{
			if (flag==true) 
			{
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	public boolean clicked(WebElement element)
	{
		element.click();
		return true;
	}


}
