package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utis.ExcelfileRead;

public class MakeMytripDataProvider {
	
	String[][] validData = {{"MAA","PNQ","15"},{"BLR","PNQ","25"}};
	
	String[][] invalidData = {{"MAA","MAA"},{"BLR","BLR"},{"PNQ","PNQ"}};
	
	@DataProvider
	public String[][] GetValidSearchData()
	{
		return validData;
	}
	
	@DataProvider
	public String[][] GetinValidSearchData()
	{
		return invalidData;
	}
	
	@DataProvider
	public String[][] GetValidDatabyExcel() throws IOException
	{
		return ExcelfileRead.ReadData("ValidData");
	}
	
	@DataProvider
	public String[][] GetinValidDatabyExcel() throws IOException
	{
		return ExcelfileRead.ReadData("inValidData");
	}
	

}
