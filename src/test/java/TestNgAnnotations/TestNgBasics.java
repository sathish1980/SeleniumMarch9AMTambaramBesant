package TestNgAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	@BeforeSuite
	public void bfsuire()
	{
		System.out.println("Before suite");
	}
	
	@AfterSuite
	public void afsuire()
	{
		System.out.println("after suite");
	}
	
	@BeforeClass
	public void bfclass()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afclass()
	{
		System.out.println("After class");
	}
	
	@Test(priority=1)
	public void Testcase()
	{
		System.out.println("firsttest");
	}

	
	@Test(priority=0)
	public void Testcase1()
	{
		System.out.println("secondtest");
	}
	
	@BeforeMethod
	public void Beforem()
	{
		System.out.println("before method");
	}
	
	
	@AfterMethod
	public void afterm()
	{
		System.out.println("after method");
	}


}
