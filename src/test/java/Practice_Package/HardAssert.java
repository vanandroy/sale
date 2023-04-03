package Practice_Package;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert {
	SoftAssert as=new SoftAssert();
	@Test
	public void test1() 
	{
		String a="hk";
		System.out.println("test1");
		System.out.println("test2");
		as.assertEquals("rk", "vk");
		System.out.println("test3");
		Assert.assertNotNull(a,"hk" );
//		Assert.assertEquals("vk", "vk");
//		Assert.assertNotSame("ravi", "rai");
		
		System.out.println("test4");
	}
	@Test
	public void test2() {
		
		System.out.println("test5");
		as.assertEquals("vk", "rk");
		System.out.println("test6");
	}
}
