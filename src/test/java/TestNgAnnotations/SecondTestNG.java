package TestNgAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTestNG {

	@Test
	public void FourthTestcase()
	{
		System.out.println("4 th test case");
	}

	@AfterMethod
	public void afterm()
	{
		System.out.println("2nd class after method");
	}

	@BeforeClass
	public void bfc()
	{
		System.out.println("Before class in second class");
	}

	@AfterClass
	public void afc()
	{
		System.out.println("after class in second class");
	}

}
