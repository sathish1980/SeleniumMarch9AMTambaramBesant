package Utis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;


public class ExcelfileRead {

	static String filepath = System.getProperty("user.dir")+"\\Input\\MakeMyTrip.xlsx";
	
	public static String[][] ReadData(String sheetName) throws IOException
	{
		String[][] data ;
		File F =new File(filepath);
		FileInputStream Fs = new FileInputStream(F);
		XSSFWorkbook wbk = new XSSFWorkbook(Fs);
		Sheet sheet = wbk.getSheet(sheetName);
		int totalrows = sheet.getPhysicalNumberOfRows();
		Row eachrow1 = sheet.getRow(0);
		int totalColumn1 = eachrow1.getLastCellNum();
		data = new String[totalrows][totalColumn1];
		for(int i=0;i<totalrows;i++)
		{
			Row eachrow = sheet.getRow(i);
			int totalColumn = eachrow.getLastCellNum();


			for (int j=0;j<totalColumn;j++)
			{
				Cell eachCell = eachrow.getCell(j);
				data[i][j]=eachCell.getStringCellValue();
				System.out.println(eachCell.getStringCellValue());
			}
		}
		wbk.close();
		return data;
	}
	
	}

