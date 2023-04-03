package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	/**
	 * This method is used to read the data from Excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @author Vivekanand
	 * @throws Throwable 
	 */
	public String readDataFromExcel(String SheetName,int RowNo,int ColumnNo) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
	    Sheet sh=wb.getSheet(SheetName);
	    String value=sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
		return SheetName;
	}
	/**
	 * This method is used to get LastRowNumber
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @author Vivekanand
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
	    Sheet sh=wb.getSheet(SheetName);
	    int count=sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write data into excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 * @author vivekanand
	 */
	public  void writeDataIntoExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(SheetName);
	    sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
	    FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
	    wb.write(fos);
	}
	/**
	 * This method used to get the multiple data from excel
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 *  @author vivekanand
	 */
	public HashMap<String,String> readMUltipleData(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(SheetName);
	    int count=sh.getLastRowNum();
	    HashMap<String,String> map=new HashMap<String,String>();
	    for(int i=0;i<=count;i++)
	    {
	    	String key=sh.getRow(i).getCell(0).getStringCellValue();
	    	String value=sh.getRow(i).getCell(1).getStringCellValue();
	    	map.put(key, value);
	    }
		return map;
	}
	/**
	 * This metthod is used to read the multiple data using Excel-Sheet and Dataprovider concept
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleSetOfDataUsingDP(String SheetName) throws Throwable  {
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
