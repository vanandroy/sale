package Product;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtility;
import com.ObjectRepo.AdminHomePage;
import com.ObjectRepo.LoginAdminPage;
import com.ObjectRepo.ProductModulePage;

@Listeners(com.GenericUtilities.ListenerImplementationClass.class)
public class AddAndVerifyProduct extends BaseClass{
	@Test(groups = {"smoke"},retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public void AddAndVerifyProd() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		HashMap<String, String> hMap = eLib.readMUltipleData("AddAndVerifyProduct");
		String pId = hMap.get("pId")+jLib.random();
		String pCategory = hMap.get("pCategory");
		String pSupplier = hMap.get("pSupplier");
		String descp = hMap.get("description");
		String qty = hMap.get("quantity");
		String price = hMap.get("price");
		String dt = hMap.get("date");	
		
		String adminUsername=fLib.readDataFromPropertyFile("ausername");
		String adminPassword=fLib.readDataFromPropertyFile("apassword");
		//Login the admin page
		LoginAdminPage loginPge=new LoginAdminPage(driver);
		loginPge.LoginAdminPage(adminUsername, adminPassword);
		wLib.acceptAlert(driver);
		AdminHomePage adHmPge=new AdminHomePage(driver);
		adHmPge.clickOnProductMod();
		ProductModulePage prdt=new ProductModulePage(driver);
		
		//creating product
		prdt.clickOnPlusIcon();
		prdt.enterProductId(pId);
		prdt.enterProductName(pSupplier);
		prdt.enterProductDescription(descp);
		prdt.enterQuantity(qty);
		prdt.enterOnHandQuant(qty);
		prdt.enterProductPrice(price);
		prdt.selectCategory(pCategory);
		prdt.selectSupplier(pSupplier);
		prdt.selectDate(dt);
		prdt.clickOnSubmit();
		Assert.fail();
		//logout the admin page
		adHmPge.logoutAdminHomePage();
	}

}
