package com.Opencart.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLibrary 
{
	@Test
	public Object getCellValue(String workbookPath,String sheetName,int rowNumber,int columnNumber) throws IOException
	{

		File file=new File(workbookPath);
		FileInputStream inputStream=new FileInputStream(file);

		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow row=  sheet.getRow(rowNumber);
		XSSFCell cell= row.getCell(columnNumber);

		Object cellValue = null;

		switch(cell.getCellType())
		{
		case STRING:cellValue=cell.getStringCellValue();break;
		case NUMERIC:cellValue=cell.getNumericCellValue();break;
		case BOOLEAN:cellValue=cell.getBooleanCellValue();break;
		}

		workbook.close();

		return cellValue;

		
	}
}
