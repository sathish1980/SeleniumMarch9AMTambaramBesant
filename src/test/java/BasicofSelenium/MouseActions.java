package BasicofSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {

	public void mouseImplementation()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//*[@class='vl-flyout-nav__js-tab']//a[text()='Electronics']"))).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Computers and tablets']")));

		mouse.moveToElement(driver.findElement(By.xpath("//a[text()='Computers and tablets']"))).click().perform();
	}

	public void mouseactions()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}

	public void draganddrop()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("form:drag_content"))).dragAndDrop(driver.findElement(By.id("form:drag_content")), driver.findElement(By.id("form:drop_content"))).perform();
	}

	public void draganddropby()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]")), -45, 0).perform();
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]")), 45, 0).perform();

	}


	public void mouseactionswithkeyboard()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouse.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mouse.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
	}

	public void keyboardwithRobot() throws AWTException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);


	}
	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.keyboardwithRobot();
	}

}
