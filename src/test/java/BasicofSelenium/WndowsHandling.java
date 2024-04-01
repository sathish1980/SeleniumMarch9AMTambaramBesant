package BasicofSelenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WndowsHandling {

	public void windowsimplementation()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		// to get the current window name
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.id("j_idt88:new")).click();
		// to get all the window name
		Set<String> allWindow = driver.getWindowHandles();
		for(String eachwindow : allWindow)
		{
			// check wether the name is not same as parent window
			if(!eachwindow.equalsIgnoreCase(parentWindow))
			{

				//Navigate in to each window
				driver.switchTo().window(eachwindow);
				//check the element exist
				List<WebElement> elementExist = driver.findElements(By.id("menuform:j_idt40"));
				if(elementExist.size()>0)
				{
					// perform the operation in child window
					driver.findElement(By.id("menuform:j_idt40")).click();
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.elementToBeClickable(By.id("menuform:m_input")));

					driver.findElement(By.id("menuform:m_input")).click();

					System.out.println(driver.getTitle());
					System.out.println(driver.getCurrentUrl());
					driver.findElement(By.id("j_idt88:name")).sendKeys("sathish");


				}
				driver.switchTo().window(parentWindow);
				driver.quit();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WndowsHandling W = new WndowsHandling();
		W.windowsimplementation();
	}

}
