package Testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.BrowserLauch;
import ElementUtils.Webelementclass;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utis.PropertyFileRead;

public class MakeMyTripSearch extends BrowserLauch {
	
	Webelementclass w = new Webelementclass();
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
	
	@Test(priority=0)
	public void ValidateSearchwithValidValues()
	{
		SearchPage sp = new SearchPage(driver);
		sp.CloseAdd();
		sp.ClickFromLocation();
		sp.SelectValueFromList("MAA");
		sp.ClickToLocation();
		sp.SelectValueFromList("PNQ");
		sp.SelectDate("15");
		sp.ClickOnSearch();
		SearchResultPage srp = new SearchResultPage(driver);
		String actualText = srp.GetErrorMessage();
		String expectedText = "NETWORK PROBLEM";
		Assert.assertEquals(actualText, expectedText);
	}
	
	/*select From Location
	 * Select same as To Location
	 * validate error message
	 * 
	 */
	@Test(priority=1)
	public void ValidateSearchwithSameCityError()
	{
		driver.navigate().back();
		SearchPage sp = new SearchPage(driver);
		sp.ClickFromLocation();
		sp.SelectValueFromList("MAA");
		sp.ClickToLocation();
		sp.SelectValueFromList("MAA");
		String actualText = sp.GetSameCityError();
		String expectedText = "From & To airports cannot be the same";
		Assert.assertEquals(actualText, expectedText);
	}

	
	
	
	
	
	@AfterSuite
	public void Close() throws IOException
	{
		CloseBrowser();
	}

}
