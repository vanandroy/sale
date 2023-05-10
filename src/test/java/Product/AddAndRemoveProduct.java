package Product;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.LoginUserPage;
import com.ObjectRepo.PointOfSalePage;
import com.ObjectRepo.UserHomePage;
//@Listeners(com.GenericUtilities.ListenerImplementationClass.class)
public class AddAndRemoveProduct extends BaseClass {
	@Test(groups = {"regression","smoke"},retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public void AddAndRemProduct() throws Throwable {
        HashMap<String, String> hMap = eLib.readMUltipleData("GenerateInvoiceByUser");
		String userUsername = fLib.readDataFromPropertyFile("uusername");
		String userPassword = fLib.readDataFromPropertyFile("upassword");
		LoginUserPage lgnUser=new LoginUserPage(driver);
		lgnUser.loginUserPage(userUsername, userPassword);
		wLib.acceptAlert(driver);
		
	    //selecting product
		UserHomePage userHmPge=new UserHomePage(driver);
		userHmPge.clickOnKeyboard();
		userHmPge.handlingDynamicXpath(driver);
		PointOfSalePage pos=new PointOfSalePage(driver);
		pos.clickOnDelete();
		System.out.println("product is deleted");
		//Assert.fail();
		userHmPge.logoutUserPage(driver);		
	}

}
