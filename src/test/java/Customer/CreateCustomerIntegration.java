package Customer;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtility;
import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.CustomerModulePage;
import com.ObjectRepo.LoginAdminPage;
@Listeners(com.GenericUtilities.ListenerImplementationClass.class)
public class CreateCustomerIntegration extends BaseClass {
	@Test(groups = {"smoke"},retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public  void CrCustIntegration() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		//getting data from hashmap
		HashMap<String, String> hMap = eLib.readMUltipleData("CreateCustomerByAdmin");
		String cFirstNme=hMap.get("cFirstName")+jLib.random();
		String cLastNme=hMap.get("cLastName");
		String fullNme=cFirstNme+" "+cLastNme;
		String productNme=hMap.get("productName");
		String phoneNumber=hMap.get("phoneNumber")+jLib.random();
		String quantity=hMap.get("quantity");
		
		//getting data from property file
        String adminUsername = fLib.readDataFromPropertyFile("ausername");
		String adminPassword = fLib.readDataFromPropertyFile("apassword");
		//Login the admin page
		LoginAdminPage loginPge=new LoginAdminPage(driver);
		loginPge.LoginAdminPage(adminUsername, adminPassword);
		wLib.acceptAlert(driver);
		
		AdminHomePage adHomPge=new AdminHomePage(driver);
		adHomPge.clickCustomerMod();
		CustomerModulePage cust=new CustomerModulePage(driver);
		cust.clickOnPlusIcon();
		cust.enterFirstNme(cFirstNme);
		cust.enterLastNme(cLastNme);
		String ph = cust.enterPhoneNmr(phoneNumber);
		cust.clickOnSubmit();
		cust.enterSearchTextBox(phoneNumber);
		String res = cust.searchResult();
		//Assert.fail();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(res, ph);
		sa.assertAll();
//		if(res.contains(ph))
//		{
//			System.out.println("Test Passed");
//		}
//		else {
//			System.out.println("Test Failed");
//		}
		adHomPge.logoutAdminHomePage();
	}

}
