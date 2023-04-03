package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteMultipleDataIntoExcel {

	public static void main(String[] args) throws Throwable {
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Sheet1");
	Object testdata[][]= {{"eid","ename","eadd"},
			              {"101","raju","mp"},
			              {"123","ram","rj"},
			              {"125","shyam","mp"}};
	int rows=testdata.length;
	int cols=testdata[0].length;
	System.out.println(rows);
	System.out.println(cols);
	for(int r=0;r<rows;r++) {
		XSSFRow row = sheet.createRow(r);
		for(int c=0;c<cols;c++) {
			XSSFCell cell = row.createCell(c);
			Object value=testdata[r][c];
			if(value instanceof String)
				cell.setCellValue((String) value);
			if(value instanceof Integer)
				cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
		}
	}
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	workbook.write(fos);
	workbook.close();
	System.out.println("ok");
		}
	}


