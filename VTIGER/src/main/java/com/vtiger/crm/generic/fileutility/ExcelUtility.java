package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		workbook.close();
		return data;
	}
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		int rowcount = workbook.getSheet(sheetName).getLastRowNum();
		workbook.close();
		return rowcount;
	}
	public void setDataintoExcelFile(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);

		FileOutputStream fos=new FileOutputStream("./testdata/testdata.xlsx");
		workbook.write(fos);
		workbook.close();
	}
}
