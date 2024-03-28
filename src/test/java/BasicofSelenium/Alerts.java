package BasicofSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public void alertsImplementation() throws InterruptedException
	{
		{
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();;
			driver.get("https://leafground.com/alert.xhtml");
			driver.findElement(By.id("j_idt88:j_idt91")).click();
			Alert a = driver.switchTo().alert();
			Thread.sleep(1000);
			a.accept();
			System.out.println(driver.findElement(By.id("simple_result")).getText());
			Thread.sleep(1000);
			driver.findElement(By.id("j_idt88:j_idt93")).click();
			a.dismiss();
			System.out.println(driver.findElement(By.id("result")).getText());
			Thread.sleep(1000);
			driver.findElement(By.id("j_idt88:j_idt104")).click();
			a.sendKeys("Besant");
			System.out.println(a.getText());
			a.accept();
			System.out.println(driver.findElement(By.id("confirm_result")).getText());


			// sweer alert
			driver.findElement(By.id("j_idt88:j_idt95")).click();
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt98")));

			driver.findElement(By.id("j_idt88:j_idt98")).click();

		}

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Alerts al = new Alerts();
		al.alertsImplementation();
	}

}
