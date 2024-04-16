package ElementUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webelementclass {
	
	
	public void EnterText(WebElement element, String texttobeEnter)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(texttobeEnter);
		}
			
	}
	
	public void ClickOnButton(WebElement element)
	{
		if(element.isDisplayed())
		{
			element.click();
		}
			
	}
	
	public String GetText(WebElement element)
	{
		if(element.isDisplayed())
		{
			return element.getText();
		}
		return null;
			
	}
	
	public String GetAttribute(WebElement element,String attribute)
	{
		if(element.isDisplayed())
		{
			return element.getAttribute(attribute);
		}
		return null;
			
	}
	
	public void WaitForElementTobeVisible(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void WaitForElementTobeClickable(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static String getScreenshot(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File SourceFile =ts.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+fileName+".png");
		FileUtils.copyFile(SourceFile,DestinationFile);
		return DestinationFile.toString();
	}
}

