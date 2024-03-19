package BasicofSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locatorspart2 {

	public void locators()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.partialLinkText("ssword?")).click();
		driver.findElement(By.cssSelector("input#email")).sendKeys("sathish");
		driver.findElement(By.cssSelector("input[data-testid='royal_email']")).sendKeys("kumar");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locatorspart2 L = new Locatorspart2();
		L.locators();
	}

}
