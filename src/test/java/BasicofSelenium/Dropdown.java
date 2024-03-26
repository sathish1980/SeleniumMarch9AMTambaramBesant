package BasicofSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {


	public void dropdwonimplementation()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("firstname")));
		driver.findElement(By.name("firstname")).sendKeys("sathish");
		/*
		 * drodown
		 * Select class
		 * 3 method
		 * SelectByindex()
		 * selectbyValue()
		 * selectbyVisibleText()
		 */
		Select daydropdown = new Select(driver.findElement(By.cssSelector("[id='day']")));
		daydropdown.selectByIndex(9);

		Select monthdropdown = new Select(driver.findElement(By.cssSelector("[id='month']")));
		monthdropdown.selectByValue("7");

		Select yeardropdown = new Select(driver.findElement(By.cssSelector("[id='year']")));
		yeardropdown.selectByVisibleText("2020");
	}

	public void multiselect()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='col-lg-3' and @id='second']")));
		if(dropdown.isMultiple())
		{
			dropdown.selectByIndex(1);
			dropdown.selectByValue("pizza");
			dropdown.selectByVisibleText("Bonda");
			dropdown.deselectByIndex(0);
			dropdown.deselectByVisibleText("Pizza");
			dropdown.deselectAll();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dropdown D = new Dropdown();
		D.multiselect();
	}

}
