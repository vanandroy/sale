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
import com.ObjectRepo.LoginUserPage;
import com.ObjectRepo.PointOfSalePage;
import com.ObjectRepo.UserHomePage;

@Listeners(com.GenericUtilities.ListenerImplementationClass.class)
public class CreateCustomerByUser extends BaseClass {
	@Test(groups = {"regression","smoke"},retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public void CrCustByUser() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		//getting multiple data from hasMap
		HashMap<String, String> hMap = eLib.readMUltipleData("CreateCustomerByUser");
		String cFirstNme=hMap.get("cFirstNme")+jLib.random();
		String cLastNme=hMap.get("cLastNme");
		String phoneNumber=hMap.get("phoneNumber")+jLib.random();
		
		//gettind data from property file
		String URL = fLib.readDataFromPropertyFile("url");
		String userUsername = fLib.readDataFromPropertyFile("uusername");
		String userPassword = fLib.readDataFromPropertyFile("upassword");
		
		 // Login the user page
		LoginUserPage lgnUser=new LoginUserPage(driver);
		lgnUser.loginUserPage(userUsername, userPassword);
		wLib.acceptAlert(driver);
		
		//Home Page
		UserHomePage userHmPge=new UserHomePage(driver);
		userHmPge.clickOnKeyboard();
		userHmPge.handlingDynamicXpath(driver);
		//Point of sale page
		PointOfSalePage pos=new PointOfSalePage(driver);
		
		//creating new customer
		pos.clickOnPlusIcon();
		pos.enterFirstName(cFirstNme);
		pos.enterLastName(cLastNme);
		String ph = pos.enterPhoneNumber(phoneNumber);
		System.out.println("phone "+ph);
		pos.clickOnSubmitForNewCust();
		wLib.acceptAlert(driver);
		
		//logout the user page
        userHmPge.logoutUserPage(driver);
        //getting data from property file for admin login
		String adminUsername = fLib.readDataFromPropertyFile("ausername");
		String adminPassword = fLib.readDataFromPropertyFile("apassword");
		
		//Login the admin page
		LoginAdminPage loginPge=new LoginAdminPage(driver);
		loginPge.LoginAdminPage(adminUsername, adminPassword);
		wLib.acceptAlert(driver);
		AdminHomePage admnHmPge=new AdminHomePage(driver);
		admnHmPge.clickCustomerMod();
		//verfying the customer by phone number
		
		CustomerModulePage cust=new CustomerModulePage(driver);
		cust.enterSearchTextBox(phoneNumber);
		String res = cust.searchResult();
		System.out.println("result "+res);
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
		admnHmPge.logoutAdminHomePage();
       

	}

}
