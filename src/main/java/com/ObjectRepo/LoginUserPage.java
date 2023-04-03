package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUserPage {

	@FindBy(name="user")
	private WebElement usernameedt;
	@FindBy(name="password")
	private WebElement pswdedt;
	@FindBy(name="btnlogin")
	private WebElement lgnclk;
	
	public LoginUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameedt()
	{
		return usernameedt;
	}

	public WebElement getPswdedt()
	{
		return pswdedt;
	}

	public WebElement getLgnclk() 
	{
		return lgnclk;
	}
//	public void usernme(String userUsername) {
//		usernameedt.sendKeys(userUsername);
//	}
//	public void pswd(String userPassword)
//	{
//		pswdedt.sendKeys(userPassword);
//	}
//	public void lgnclk() {
//		lgnclk.click();
//	}
	public void loginUserPage(String userUsername,String userPassword) {
    	usernameedt.sendKeys(userUsername);
    	pswdedt.sendKeys(userPassword);
    	lgnclk.click();
    }
}
