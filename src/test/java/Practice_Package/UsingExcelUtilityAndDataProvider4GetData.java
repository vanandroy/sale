package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class UsingExcelUtilityAndDataProvider4GetData {
	@DataProvider
public   Object[][] data4() throws Throwable {
	ExcelUtility eLib=new ExcelUtility();
	Object[][] obj = eLib.readMultipleSetOfDataUsingDP("Data_provider");
	return obj;
	
}
	@Test(dataProvider = "data4")
	public void getData(String src,String dst) {
		System.out.println("from "+src+" to "+dst);
		
	}
}
