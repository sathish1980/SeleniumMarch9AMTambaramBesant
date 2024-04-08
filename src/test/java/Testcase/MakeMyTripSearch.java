package Testcase;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.BrowserLauch;
import Utis.PropertyFileRead;

public class MakeMyTripSearch extends BrowserLauch {
	
	@BeforeSuite
	public void BrowserLaunch() throws IOException
	{
		Launch();
	}
	
	@BeforeTest
	public void LaunchTheURL() throws IOException
	{
		String URL = PropertyFileRead.ReadPropertyfile().getProperty("url");
		driver.get(URL);
	}
	
	/*
	 * Close the Add
	 * select From Location
	 * Select To Location
	 * Select Date
	 * Click On Search
	 * Validate the search result
	 */
	
	@Test
	public void ValidateSearchwithValidValues()
	{
		CloseAdd();
		ClickFromLocation();
		ClickToLocation();
		SelectDate();
		ClickOnSearch();
	}

	
	public void CloseAdd()
	{
		
	}
	
	public void ClickFromLocation()
	{
		
	}
	
	public void ClickToLocation()
	{
		
	}
	
	public void SelectDate()
	{
		
	}
	
	public void ClickOnSearch()
	{
		
	}
	@AfterSuite
	public void Close() throws IOException
	{
		CloseBrowser();
	}

}
