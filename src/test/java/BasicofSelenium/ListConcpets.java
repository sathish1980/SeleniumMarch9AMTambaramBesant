package BasicofSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListConcpets {


	public void listimplementation(String expectedCountry)
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		//click the list
		driver.findElement(By.xpath("//*[@id='j_idt87:country']//child::div[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		//wait to load all elements in the list
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//li[last()]")));
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
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListConcpets L = new ListConcpets();
		L.listimplementation("USA");
	}

}
