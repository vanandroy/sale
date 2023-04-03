package Practice_Package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Demo {
	
	public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int rows = sh.getLastRowNum();
	for(int r=0;r<rows;r++) {
		String eid = sh.getRow(r).getCell(0).getStringCellValue();
		String ename = sh.getRow(r).getCell(1).getStringCellValue();
		System.out.print(eid+"  ");
		System.out.println(ename+"  ");
	}
	}

}
