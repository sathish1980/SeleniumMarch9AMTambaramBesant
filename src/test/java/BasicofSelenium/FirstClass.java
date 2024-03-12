package BasicofSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {

	public void launch()
	{
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass f = new FirstClass();
		f.launch();

	}

}
