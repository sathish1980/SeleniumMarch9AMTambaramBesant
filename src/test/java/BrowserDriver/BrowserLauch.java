package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utis.PropertyFileRead;

public class BrowserLauch {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	String reportPath = System.getProperty("user.dir")+"\\Reports\\makemyTripAutomation.html";
	
	public void Launch() throws IOException
	{
		String actualBrowserName = PropertyFileRead.ReadPropertyfile().getProperty("browser");
		if(actualBrowserName.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
		}
		else if(actualBrowserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		reports = new ExtentReports(reportPath,true); // true - keep only the current execution result
		//test = reports.startTest("Automation");
		driver.manage().window().maximize();
	}
	
	
	public void CloseBrowser()
	{
		if(driver!=null)
		{
			reports.flush();
			driver.quit();
		}
	}
	

}
