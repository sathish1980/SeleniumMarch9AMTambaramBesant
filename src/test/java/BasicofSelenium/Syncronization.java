package BasicofSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Syncronization {

	/*
	 * 1. 	implicitly wait
	 * 2.	Explicit wait
	 * 3.	fluent wait
	 * 4. Thread.sleep
	 */

	public void createAccount()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("firstname")));
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("firstname")).sendKeys("sathish");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Syncronization s = new Syncronization();
		s.createAccount();
	}

}
