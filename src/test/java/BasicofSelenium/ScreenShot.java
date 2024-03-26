package BasicofSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenShot {

	WebDriver driver;
	public void listimplementation(String expectedCountry)
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		takeSCreenshot("base");
		//click the list
		driver.findElement(By.xpath("//*[@id='j_idt87:country']//child::div[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		//wait to load all elements in the list
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//li[last()]")));
		takeSCreenshot("openlist");
		// get all the value from the list
		List<WebElement> allCountry =driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		// iterate and get each element
		for(WebElement eachContry : allCountry)
		{
			//get country name for each element
			String actualCountry = eachContry.getText();
			// if both are matched (actuall == expected)
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				// select the value from the list
				eachContry.click();
				takeSCreenshot("selected");
				break;
			}
		}
	}

	public void takeSCreenshot(String filename)
	{
		TakesScreenshot tk =(TakesScreenshot) driver;
		File sourceFile = tk.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+filename+".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScreenShot L = new ScreenShot();
		L.listimplementation("USA");
	}

}
