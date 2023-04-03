package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation_Practice {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("----connecting to DB----");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("----disconnecting DB----");
	}
	@BeforeClass
	public void beforeclass() {
		System.out.println("----opening browser----");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("----closing the browser----");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("----login the app----");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("----logout the app----");
	}
	@Test
	public void testScript1() {
		System.out.println("execute script1");
	}
	@Test
	public void testScript2() {
		System.out.println("execute script2");
	}
}
