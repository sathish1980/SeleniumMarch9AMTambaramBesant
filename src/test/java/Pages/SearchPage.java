	package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ElementUtils.Webelementclass;

public class SearchPage extends Webelementclass{
	
	WebDriver driver;
	@FindBy (className="close")
	WebElement button;
	@FindBy (xpath="//*[@for='fromCity']")
	WebElement fromLocation;
	@FindBy (xpath="//*[@for='toCity']")
	WebElement toLocation;
	@FindBy (xpath ="//*[text()='Search']")
	WebElement SearchButton;
	@FindBy (xpath="//*[@data-cy='sameCityError']")
	WebElement SameCityError;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void CloseAdd()
	{
		try
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("webklipper-publisher-widget-container-notification-frame"));
			List<WebElement> elementexist = driver.findElements(By.className("close"));
			if(elementexist.size()>0)
			{
				//WebElement button = driver.findElement(By.className("close"));
				ClickOnButton(button);
			}
			driver.switchTo().defaultContent();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void ClickFromLocation()
	{
		WaitForElementTobeClickable(driver, By.xpath("//*[@for='fromCity']"));
		//ClickOnButton(driver.findElement(By.xpath("//*[@for='fromCity']")));
		ClickOnButton(fromLocation);
			
	}
	
	public void SelectValueFromList(String expectedText)
	{

		String alllocElement = "(//*[@id='react-autowhatever-1']//ul)[last()]//li";
		List<WebElement> allLocation = driver.findElements(By.xpath(alllocElement));
		for(int i=1;i<=allLocation.size();i++)
		{
			String actualCode = driver.findElement(By.xpath(alllocElement+"["+i+"]//div[starts-with(@class,'font14')]")).getText();
			System.out.println(actualCode);
			if(actualCode.equalsIgnoreCase(expectedText)) {
				ClickOnButton(driver.findElement(By.xpath(alllocElement+"["+i+"]")));
				break;
			}
		}

	}
	
	public void ClickToLocation()
	{
		WaitForElementTobeClickable(driver, By.xpath("//*[@for='toCity']"));
		//ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		ClickOnButton(toLocation);
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
				String className = GetAttribute(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]")),"class");
				if(!(className.contains("disabled") || className.contains("outside")))
				{
					String actualDate = GetText(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]//p[1]")));
					if(actualDate.equalsIgnoreCase(expectedDate))
					{
						ClickOnButton(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]")));
						break;
					}
				}
			}
		}
	}
	
	public void ClickOnSearch()
	{
		ClickOnButton(SearchButton);
		//ClickOnButton(driver.findElement(By.xpath("//*[text()='Search']")));

	}
	
	public String GetSameCityError()
	{
		WaitForElementTobeVisible(driver, By.xpath("//*[@data-cy='sameCityError']"));
		//return GetText(driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		return GetText(SameCityError);
		
	}
	

}
