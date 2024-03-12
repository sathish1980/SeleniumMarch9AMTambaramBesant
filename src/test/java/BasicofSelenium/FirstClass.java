package BasicofSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {

	public void launch()
	{
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.navigate().to("https://www.gmail.com");
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		//driver.manage().window().minimize();
		//driver.close();
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass f = new FirstClass();
		f.launch();

	}

}
