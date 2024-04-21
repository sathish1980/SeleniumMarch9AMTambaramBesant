package Testcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BrowserDriver.BrowserLauch;
import ElementUtils.Webelementclass;
import Utis.PropertyFileRead;

public class MakemyTripTestcase extends BrowserLauch {
	
	/*
	 *  lauch the browser and enter the ur;
	 * 	Select from location
	 * select to location
	 * select date
	 * click on search
	 * Validate search result displays Network error
	 */
	Webelementclass W = new Webelementclass();
	@BeforeSuite
	public void LaunchTheBrowserAndEnterTheURL() throws IOException
	{
		Launch();
		String url = PropertyFileRead.ReadPropertyfile().getProperty("url");
		driver.get(url);
	}
	
	@AfterSuite
	public void CloseTheBrowser()
	{
		driver.quit();
	}
	
	@BeforeClass
	public void LoginPopupExsist()
	{
		W.WaitForElementTobeClickable(driver, By.xpath("//*[@data-cy='closeModal']"));
		W.ClickOnButton(driver.findElement(By.xpath("//*[@data-cy='closeModal']")));
	}
	@Test(priority=0,dataProvider="GetMakeMyTripSearchdata",dataProviderClass=MakeMytripDataProvider.class)
	public void ValidatedSearchUsingValidValues(String from,String to,String date)
	{
		ClickFromLocation();
		SelectTheValueFromList(from);
		ClickToLocation();
		SelectTheValueFromList(to);
		SelectDate(date);
		ClicOnSearchButton();
		String actualError =GetErrorMessage();
		String expectedError = "NETWORK PROBLEM";
		Assert.assertEquals(actualError, expectedError);
		driver.navigate().back();
	}
	
	@Test(priority=1,dataProvider="GetinValidDatabyExcel",dataProviderClass=MakeMytripDataProvider.class)
	public void ValidateSameCityError(String from,String to)
	{
		ClickFromLocation();
		SelectTheValueFromList(from);
		ClickToLocation();
		SelectTheValueFromList(to);
		String actualError =GetSameCityErrorMessage();
		String expectedError = "From & To airports cannot be the same";
		Assert.assertEquals(actualError, expectedError);
	}
	
	public void ClickFromLocation()
	{
		
		W.WaitForElementTobeClickable(driver, By.xpath("//*[@for='fromCity']"));
		WebElement fromLocation= driver.findElement(By.xpath("//*[@for='fromCity']"));
		W.ClickOnButton(fromLocation);
			
	}
	
	public void SelectTheValueFromList(String expectedText)
	{
		String alllocElement = "(//*[@id='react-autowhatever-1']//ul)[last()]//li";
		List<WebElement> allLocation = driver.findElements(By.xpath(alllocElement));
		for(int i=1;i<=allLocation.size();i++)
		{
			String actualCode = driver.findElement(By.xpath(alllocElement+"["+i+"]//div[starts-with(@class,'font14')]")).getText();
			System.out.println(actualCode);
			if(actualCode.equalsIgnoreCase(expectedText)) {
				W.ClickOnButton(driver.findElement(By.xpath(alllocElement+"["+i+"]")));
				break;
			}
		}
	}
	public void ClickToLocation()
	{
		W.WaitForElementTobeClickable(driver, By.xpath("//*[@for='toCity']"));
		WebElement fromLocation= driver.findElement(By.xpath("//*[@for='toCity']"));
		W.ClickOnButton(fromLocation);
	}
	
	public void SelectDate(String expectedDate)
	{
		String calenderWeekPath ="(//*[@class='DayPicker-Month'])[2]//*[@class='DayPicker-Week']";
		List<WebElement> totalWeeks = driver.findElements(By.xpath(calenderWeekPath));
		for(int i=1;i<=totalWeeks.size();i++)
		{
			List<WebElement> eachDayinWeek = driver.findElements(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]"));
			for(int j=1;j<=eachDayinWeek.size();j++)
			{
				String className = W.GetAttribute(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]")),"class");
				if(!(className.contains("disabled") || className.contains("outside")))
				{
					String actualDate = W.GetText(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]//p[1]")));
					if(actualDate.equalsIgnoreCase(expectedDate))
					{
						W.ClickOnButton(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]")));
						break;
					}
				}
			}
		}
	}
	
	public void ClicOnSearchButton()
	{
		W.ClickOnButton(driver.findElement(By.xpath("//*[text()='Search']")));
	}
	
	public void ValidateResult()
	{
		
	}
	
	public String GetErrorMessage()
	{
		W.WaitForElementTobeVisible(driver,By.className("error-title"));
		//return GetText(driver.findElement(By.className("error-title")));
		return W.GetText(driver.findElement(By.className("error-title")));
		
	}
	
	public String GetSameCityErrorMessage()
	{
		W.WaitForElementTobeVisible(driver,By.xpath("//*[@data-cy='sameCityError']"));
		//return GetText(driver.findElement(By.className("error-title")));
		return W.GetText(driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		
	}

}
