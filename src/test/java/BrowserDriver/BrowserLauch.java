package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utis.PropertyFileRead;

public class BrowserLauch {
	
	public static WebDriver driver;
	
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
		
		driver.manage().window().maximize();
	}
	
	
	public void CloseBrowser()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	

}
