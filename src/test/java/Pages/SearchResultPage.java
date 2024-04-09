package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ElementUtils.Webelementclass;

public class SearchResultPage extends Webelementclass {
	WebDriver driver;
	@FindBy (className="error-title")
	WebElement error;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String GetErrorMessage()
	{
		WaitForElementTobeVisible(driver,By.className("error-title"));
		//return GetText(driver.findElement(By.className("error-title")));
		return GetText(error);
		
	}

}
