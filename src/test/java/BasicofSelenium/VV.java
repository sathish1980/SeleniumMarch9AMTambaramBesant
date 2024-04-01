package BasicofSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class VV {

	// validation
	/*
	 * isSelected()
	 * isDisplayed()
	 * isEnabled()
	 */
	public void vvimplementation()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println(driver.findElement(By.xpath("(//*[@class='card']//h5)[1]")).getText());
		System.out.println(driver.findElement(By.className("ui-selectonemenu")).getAttribute("style"));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		System.out.println(driver.findElement(By.className("ui-selectonemenu")).getCssValue("background"));

	}

	public static void main(String[] args) {
		VV  v = new VV();
		v.vvimplementation();

	}

}
