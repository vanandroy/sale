package Practice_Package;

import org.testng.annotations.Test;

public class Data_Provider2_Test {
	@Test(dataProviderClass =Data_Provider2.class,dataProvider = "data" )
	public void getData(String src,String dst,String loc) {
		System.out.println("from "+src+" to "+dst+" Location "+loc);
	}
}
