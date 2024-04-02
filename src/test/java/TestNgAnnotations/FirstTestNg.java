package TestNgAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNg {

	@BeforeMethod
	public void BeforeM()
	{
		System.out.println("BeforeMethod");
	}


	@BeforeClass
	public void BeforeC()
	{
		System.out.println("BeforeClass");
	}


	@Test(priority=0,timeOut=60,dependsOnMethods="ThirdTestcase")
	public void FirstTestcase()
	{
		System.out.println("FirstTestcase");
	}



	@Test(priority=1,enabled=true,invocationCount=5,invocationTimeOut=60,description="valid")
	public void ThirdTestcase()
	{
		System.out.println("thirdTestcase");
	}

	@Test(priority=2)
	public void SecondTestcase()
	{
		//throw new ArithmeticException("Error");
		System.out.println("SecondTestcase");
	}

	@AfterMethod
	public void AfterM()
	{
		System.out.println("AfterMethod");
	}


}
