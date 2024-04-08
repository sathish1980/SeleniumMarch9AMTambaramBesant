package ElementUtils;

import java.time.Duration;

import org.openqa.selenium.By;
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
}
