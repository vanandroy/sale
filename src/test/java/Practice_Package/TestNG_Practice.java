package Practice_Package;

import org.testng.annotations.Test;

public class TestNG_Practice {
	@Test(priority = 1,invocationCount = 2)
	public void createCustomer() {
		System.out.println("createCustomer");
	}
	@Test(priority = 2,invocationCount = 3)
	public void editCustomer() {
		System.out.println("editCustomer");
		//Reporter.log("editCustomer");
	}
	@Test(priority = 3,invocationCount = 2)
	public void deleteCustomer() {
		//Reporter.log("deleteCustomer");
		System.out.println("deleteCustomer");
	}
}
