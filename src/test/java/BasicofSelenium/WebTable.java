package BasicofSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTable {

	WebDriver driver;
	public void Webtableimplementation(String expectedCountry) throws InterruptedException
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		// Take all the pages
		List<WebElement> allpages = driver.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=allpages.size();j++)
		{
			driver.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			Thread.sleep(2000);
			checkonEachRow(expectedCountry);
		}
	}

	public void checkonEachRow(String expectedCountry)
	{



		//Take all the rows
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='form:j_idt89']//div[@class='ui-datatable-scrollable-body']//table//tbody//tr"));
		int totalRowSize = allRows.size();

		for(int i=1;i<=totalRowSize;i++)
		{
			String eachCountry = driver.findElement(By.xpath("//*[@id='form:j_idt89']//div[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[2]//span[starts-with(@style,'vertical-align:')]")).getText();
			if(expectedCountry.equalsIgnoreCase(eachCountry))
			{
				String name = driver.findElement(By.xpath("//*[@id='form:j_idt89']//div[@class='ui-datatable-scrollable-body']//table//tbody//tr["+i+"]//td[1]")).getText();
				System.out.println(name);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable W = new WebTable();
		W.Webtableimplementation("France");
	}

}
