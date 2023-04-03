package Transaction;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtility;
import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.LoginAdminPage;
import com.ObjectRepo.LoginUserPage;
import com.ObjectRepo.PointOfSalePage;
import com.ObjectRepo.TransactionModulePage;
import com.ObjectRepo.UserHomePage;
@Listeners(com.GenericUtilities.ListenerImplementationClass.class)
public class CreateTransactionByUser extends BaseClass {
	@Test(groups ={"regression","smoke"},retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public  void CreateTransactionByUser() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		String userUsername = fLib.readDataFromPropertyFile("uusername");
		String userPassword = fLib.readDataFromPropertyFile("upassword");
//      Login the user page
		LoginUserPage lgnUser=new LoginUserPage(driver);
		lgnUser.loginUserPage(userUsername, userPassword);
		wLib.acceptAlert(driver);
		
		HashMap<String, String> hMap = eLib.readMUltipleData("CreateTransactionByUser");
		String cFirstNme = hMap.get("cFirstNme");
		String cLastNme = hMap.get("cLastNme");
		String txnNumber=hMap.get("txnNumber");
		String fullName=cFirstNme+" "+cLastNme;
		
		UserHomePage userHmPge=new UserHomePage(driver);
		userHmPge.clickOnKeyboard();
		userHmPge.handlingDynamicXpath(driver);
		PointOfSalePage pos=new PointOfSalePage(driver);
		pos.selectCustFromDpDwn(fullName);
		pos.clickOnSubmit();
		
		wLib.switchToWindowHandle(driver);
		pos.enterCash(txnNumber);
		pos.clickOnProceedPayment();
		wLib.acceptAlert(driver);
		
		//logout the user page
		userHmPge.logoutUserPage(driver);
		//Login the admin page	
	    String adminUsername = fLib.readDataFromPropertyFile("ausername");
		String adminPassword=fLib.readDataFromPropertyFile("apassword");
		LoginAdminPage loginPge=new LoginAdminPage(driver);
		loginPge.LoginAdminPage(adminUsername, adminPassword);
		wLib.acceptAlert(driver);
		
		AdminHomePage adminHmPge=new AdminHomePage(driver);
		adminHmPge.clickOnTransactionMod();
		TransactionModulePage txnPge=new TransactionModulePage(driver);
		txnPge.enterTxnNumber(txnNumber);
		txnPge.clickOnView();		
		
		String expName =txnPge.handlinDynamicXpath(driver);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(fullName, expName);
		sa.assertAll();
		
//		if(fullName.equals(expName)) {
//			System.out.println("Test case pass");
//		}
//		else {
//			System.out.println("Test case not pass");
//		}


	}

}
