package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class LoginAdminPage {

	@FindBy(name="user")
	private WebElement usernameedt;
	@FindBy(name="password")
	private WebElement pswdedt;
	@FindBy(name="btnlogin")
	private WebElement lgnclk;
	
	public LoginAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPswdedt() {
		return pswdedt;
	}

	public WebElement getLgnclk() {
		return lgnclk;
	}
//	public void usernme(String adminUsername) {
//		usernameedt.sendKeys(adminUsername);
//	}
//	public void pswd(String adminPassword)
//	{
//		pswdedt.sendKeys(adminPassword);
//	}
//	public void lgnclk() {
//		lgnclk.click();
//	}
	public void LoginAdminPage(String adminUsername,String adminPassword) {
		usernameedt.sendKeys(adminUsername);
		pswdedt.sendKeys(adminPassword);
		lgnclk.click();
		
	}
}
