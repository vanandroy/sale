package Transaction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtility;
import com.ObjectRepo.LoginUserPage;
import com.ObjectRepo.PointOfSalePage;
import com.ObjectRepo.UserHomePage;

@Listeners(com.GenericUtilities.ListenerImplementationClass.class)
public class GenerateInvoiceByUser extends BaseClass{
	@Test(groups = {"regression"},retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public void GenInvoiceByUser() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		String userUsername = fLib.readDataFromPropertyFile("uusername");
		String userPassword = fLib.readDataFromPropertyFile("upassword");
//      Login the user page
		LoginUserPage lgnUser=new LoginUserPage(driver);
		lgnUser.loginUserPage(userUsername, userPassword);
		wLib.acceptAlert(driver);
		
		HashMap<String, String> hMap = eLib.readMUltipleData("GenerateInvoiceByUser");
		String cFirstName = hMap.get("cFirstNme")+jLib.random();
		String cLastName = hMap.get("cLastNme");
		String phnNumber=hMap.get("phnNumber")+jLib.random();
		String txnNumber=hMap.get("txnNumber")+jLib.random();
		String fullName=cFirstName+" "+cLastName;
		
		String actualTile=hMap.get("actualTile");
		UserHomePage userHmpge=new UserHomePage(driver);
		userHmpge.clickOnKeyboard();
		userHmpge.handlingDynamicXpath(driver);
		
		PointOfSalePage pos=new PointOfSalePage(driver);
        pos.clickOnPlusIcon();
		pos.enterFirstName(cFirstName);
		pos.enterLastName(cLastName);
		pos.enterPhoneNumber(phnNumber);
		pos.clickOnSubmitForNewCust();
		wLib.acceptAlert(driver);
		
		wLib.waitForPageLoad(driver);
		pos.selectCustFromDpDwn(fullName);
		pos.clickOnSubmit();
		
		wLib.switchToWindowHandle(driver);
		pos.enterCash(txnNumber);
		pos.clickOnProceedPayment();
		wLib.acceptAlert(driver);		
		
        String ExpectedTitle= pos.titleOfUserPage();
       //Assert.fail();
        SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualTile, ExpectedTitle);
		sa.assertAll();
////		if(actualTile.equals(ExpectedTitle)) {
//			System.out.println("Invoice is Generated");
//		}
//		else {
//			System.out.println("Invoice is Not Generated");
//		}
		UserHomePage userHmPge=new UserHomePage(driver);
		userHmPge.logoutUserPage(driver);
	}

}
