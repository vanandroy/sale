package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider1 {
	@Test(dataProvider = "data")
	public void getData(String src,String dst,String loc) {
		System.out.println("from "+src+" to "+dst+" Location "+loc);
	}
	@DataProvider
	public Object[][] data(){
		// Object[][] obj=new Object[3][3];	
//		obj[0][0]="01";
//		obj[0][1]="ram";
//		obj[0][2]="patna";
//		
//		obj[1][0]="02";
//		obj[1][1]="shyam";
//		obj[1][2]="gaya";
//		
//		obj[2][0]="03";
//		obj[2][1]="ramya";
//		obj[2][2]="bhopal";
		Object obj[][]= {{"01","ram","patna"},{"02","shyam","gaya"},{"03","ramya","bhopal"}};
		
		return obj;
		
	}
}
