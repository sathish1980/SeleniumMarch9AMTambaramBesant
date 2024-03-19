package BasicofSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Xpath {

	/*
	 * /html/body/div/div/div/div/div/div/div[2]/div/div/form/div/div/input
	 */

	public void implement()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("(//*[@class='_6lux']//input)[2]")).sendKeys("sathish");
		WebElement button =driver.findElement(By.xpath("//button[text()='Log in' or text()='signup']"));
		button.click();

		button.click();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xpath x = new Xpath();
		x.implement();
	}

}
