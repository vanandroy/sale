package com.ObjectRepo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.WebDriverUtility;

public class UserHomePage {
    
	@FindBy(xpath="//a[@data-target='#keyboard']")
	private WebElement clkOnKeyboard;
	
	@FindBy(xpath="//a[@id='userDropdown']")
	private WebElement userDpDwn;
	@FindBy(xpath="//a[@data-target='#logoutModal']/i")
	private WebElement logoutModal;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutClk;
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getclkOnKeyboard() {
		return clkOnKeyboard;
	}
	public WebElement getUserDpDwn() {
		return userDpDwn;
	}
	public WebElement getLogoutModal() {
		return logoutModal;
	}
	public WebElement getLogoutClk() {
		return logoutClk;
	}
	public void clickOnKeyboard() {
		clkOnKeyboard.click();
	}

	public void logoutUserPage(WebDriver driver) {
		userDpDwn.click();
		logoutModal.click();
		WebDriverUtility eLib=new WebDriverUtility();
		eLib.switchToWindowHandle(driver);
		logoutClk.click();
	}
	public void handlingDynamicXpath(WebDriver driver) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		HashMap<String, String> hMap = eLib.readMUltipleData("GenerateInvoiceByUser");
		String productName=hMap.get("prdName");
		String qty=hMap.get("quantity");
		driver.findElement(By.xpath("//h6[.='"+productName+"']/following-sibling::input[1]")).sendKeys(qty);
		driver.findElement(By.xpath("//h6[.='"+productName+"']/following-sibling::input[4]")).click();
	}

}
