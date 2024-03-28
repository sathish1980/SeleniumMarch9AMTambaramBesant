package BasicofSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Frames {

	public void FrameImplementation()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");

		//driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();

		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));

		for(int i=0;i<allFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> elementexist =driver.findElements(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]"));

			if(elementexist.size()>0)
			{
				driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();
				break;
			}
			driver.switchTo().defaultContent();

		}
	}

	public void FrameImplementationmultiple()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");

		//driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();

		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));

		for(int i=0;i<allFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> nextFrames = driver.findElements(By.tagName("iframe"));
			if(nextFrames.size()>0)
			{
				driver.switchTo().frame("frame2");
				List<WebElement> elementexist =driver.findElements(By.xpath("//*[@id='Click' and contains(@style,'4b7ecf')]"));
				if(elementexist.size()>0)
				{
					driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'4b7ecf')]")).click();
					break;
				}
			}
			driver.switchTo().defaultContent();

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.FrameImplementationmultiple();
	}

}
