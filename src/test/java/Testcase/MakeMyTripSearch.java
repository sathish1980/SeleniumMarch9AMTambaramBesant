package Testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

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
	
	@BeforeClass
	public void ClickOnAdd()
	{
		SearchPage sp = new SearchPage(driver);
		//sp.CloseAdd();
	}
	
	@BeforeMethod
	public void CreateReportName(ITestResult result)
	{
		test = reports.startTest(result.getMethod().getMethodName());
	}
	
	/*
	 * Close the Add
	 * select From Location
	 * Select To Location
	 * Select Date
	 * Click On Search
	 * Validate the search result
	 */
	
	@Test(priority=0,dataProvider="GetValidDatabyExcel",dataProviderClass=MakeMytripDataProvider.class)
	public void ValidateSearchwithValidValues(String from,String to, String date)
	{
		SearchPage sp = new SearchPage(driver);
		//sp.CloseAdd();
		sp.ClickFromLocation();
		sp.SelectValueFromList(from);
		test.log(LogStatus.INFO,"USer select From location as : "+from);
		sp.ClickToLocation();
		sp.SelectValueFromList(to);
		test.log(LogStatus.INFO,"USer select To location as : "+to);
		sp.SelectDate(date);
		test.log(LogStatus.INFO,"USer select date as : "+date);
		sp.ClickOnSearch();
		test.log(LogStatus.INFO,"User clicked on search butt");
		SearchResultPage srp = new SearchResultPage(driver);
		String actualText = srp.GetErrorMessage();
		String expectedText = "NETWORK PROBLEM";
		Assert.assertEquals(actualText, expectedText);
		test.log(LogStatus.INFO,"Your first test case is passed");
		driver.navigate().back();
	}
	
	/*select From Location
	 * Select same as To Location
	 * validate error message
	 * 
	 */
	@Test(priority=1,dataProvider="GetinValidDatabyExcel",dataProviderClass=MakeMytripDataProvider.class)
	public void ValidateSearchwithSameCityError(String from,String to)
	{
		
		SearchPage sp = new SearchPage(driver);
		sp.ClickFromLocation();
		sp.SelectValueFromList(from);
		test.log(LogStatus.INFO,"USer select From location as : "+from);
		sp.ClickToLocation();
		sp.SelectValueFromList(to);
		test.log(LogStatus.INFO,"USer select to location as : "+to);
		String actualText = sp.GetSameCityError();
		String expectedText = "From & To airports cannot be the same";
		Assert.assertEquals(actualText, expectedText);
		test.log(LogStatus.INFO,"From location "+ from + "To location "+to+"are same");
	}

	
	
	@AfterMethod
	public void ReportUpdate(ITestResult result) throws IOException
	{
		if (result.getStatus() == 1) {
			String screenshotPath =Webelementclass.getScreenshot(driver,result.getMethod().getMethodName());
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath)); 
			test.log(LogStatus.PASS, result.getMethod().getMethodName() +" Test Passed");  // new
		} else if (result.getStatus() == 2) {
			//SearchPage sp = new SearchPage(driver);
			String screenshotPath =Webelementclass.getScreenshot(driver,result.getMethod().getMethodName());
			test.log(LogStatus.INFO, result.getMethod().getMethodName() +" Test Error info",test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() +" Test Error");  // new
		} else if (result.getStatus() == 3) {
			test.log(LogStatus.SKIP, result.getMethod().getMethodName()+" Test Skipped");  // new
		}
	}
	
	@AfterSuite
	public void Close() throws IOException
	{
		CloseBrowser();
	}

}
