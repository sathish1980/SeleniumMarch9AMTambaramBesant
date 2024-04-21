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
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utis.PropertyFileRead;

public class MakemyTripTestcasewithPageobject extends BrowserLauch {
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
		SearchPage s = new SearchPage(driver);
		s.ClickFromLocation();
		s.SelectValueFromList(from);
		s.ClickToLocation();
		s.SelectValueFromList(to);
		s.SelectDate(date);
		s.ClickOnSearch();
		SearchResultPage srp = new SearchResultPage(driver);
		String actualError =srp.GetErrorMessage();
		String expectedError = "NETWORK PROBLEM";
		Assert.assertEquals(actualError, expectedError);
		driver.navigate().back();
	}
	
	@Test(priority=1,dataProvider="GetinValidDatabyExcel",dataProviderClass=MakeMytripDataProvider.class)
	public void ValidateSameCityError(String from,String to)
	{
		SearchPage s = new SearchPage(driver);
		s.ClickFromLocation();
		s.SelectValueFromList(from);
		s.ClickToLocation();
		s.SelectValueFromList(to);
		String actualError =s.GetSameCityError();
		String expectedError = "From & To airports cannot be the same";
		Assert.assertEquals(actualError, expectedError);
	}
	
	

}
