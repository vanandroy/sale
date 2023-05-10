package Customer;

import static org.testng.Assert.fail;

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
public class CreateCustomerByAdmin extends BaseClass {
	
	@Test(groups = {"regression","smoke"})
	public  void CrCustByAdmin() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		
		//getting data from hashmap
		HashMap<String, String> hMap = eLib.readMUltipleData("CreateCustomerByAdmin");
		String cFirstNme=hMap.get("cFirstName")+jLib.random();
		String cLastNme=hMap.get("cLastName");
		String fullNme=cFirstNme+" "+cLastNme;
		String phoneNumber=hMap.get("phoneNumber")+jLib.random();
		
		//getting data from property file
        String adminUsername = fLib.readDataFromPropertyFile("ausername");
		String adminPassword = fLib.readDataFromPropertyFile("apassword");
//		Login the admin page
		LoginAdminPage loginPge=new LoginAdminPage(driver);
		loginPge.LoginAdminPage(adminUsername, adminPassword);
		
		//accepting alert popup
		wLib.acceptAlert(driver);
		AdminHomePage adHomPge=new AdminHomePage(driver);
		adHomPge.clickCustomerMod();
		CustomerModulePage cust=new CustomerModulePage(driver);
		cust.clickOnPlusIcon();
		cust.enterFirstNme(cFirstNme);
		cust.enterLastNme(cLastNme);
		cust.enterPhoneNmr(phoneNumber);
		cust.clickOnSubmit();
		adHomPge.logoutAdminHomePage();
		String userUsername = fLib.readDataFromPropertyFile("uusername");
		String userPassword = fLib.readDataFromPropertyFile("upassword");
		
//       Login the user page
		LoginUserPage lgnUser=new LoginUserPage(driver);
		lgnUser.loginUserPage(userUsername, userPassword);
        wLib.acceptAlert(driver);
        
        UserHomePage userHmPge=new UserHomePage(driver);
        userHmPge.clickOnKeyboard();
       userHmPge.handlingDynamicXpath(driver);
		PointOfSalePage pos=new PointOfSalePage(driver);
		String actualName = pos.selectCustFromDpDwn(fullNme);
		String expectedName=fullNme;
		//Assert.fail();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualName, expectedName);
		sa.assertAll();
//		if(actualName.equals(expectedName)) {
//			System.out.println("Test passes");
//		}
//		else {
//			System.out.println("Test failed");
//		}
		userHmPge.logoutUserPage(driver);
		
	}
}


