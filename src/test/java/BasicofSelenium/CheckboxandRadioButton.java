package BasicofSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxandRadioButton {


	public void checkbox()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//child::*[starts-with(@class,'ui-chkbox-box')]")).click();
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-growl-title")));
		String toastText = driver.findElement(By.className("ui-growl-title")).getText();
		System.out.println(toastText);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-growl-title")));
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-growl-title")));
		String toastText1 = driver.findElement(By.className("ui-growl-title")).getText();
		System.out.println(toastText1);
		String classNAme = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//child::*[starts-with(@class,'ui-chkbox-box')]")).getAttribute("class");
		if(!classNAme.contains("disabled"))
			driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//child::*[starts-with(@class,'ui-chkbox-box')]")).click();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckboxandRadioButton c = new CheckboxandRadioButton();
		c.checkbox();
	}

}
