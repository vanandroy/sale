package Practice_Package;

import org.testng.annotations.Test;

public class GetDataUsingDataprovider3Excel {
	@Test(dataProviderClass = Data_Provider3.class,dataProvider = "data")
	public void getData(String src,String dst) {
		System.out.println("from "+src+" to "+dst);
	}
}