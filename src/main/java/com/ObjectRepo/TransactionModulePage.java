package com.ObjectRepo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;

public class TransactionModulePage {
	
	@FindBy(xpath="//div[@id='dataTable_filter']//label")
	private WebElement enterTxn;
	@FindBy(xpath="//tr/td[4]")
	private WebElement clkView;
	public TransactionModulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getEnterTxn() {
		return enterTxn;
	}
	public WebElement getClkView() {
		return clkView;
	}
	public void enterTxnNumber(String txnNumber) {
		enterTxn.sendKeys(txnNumber);
	}
	public void clickOnView() {
		clkView.click();
	}
	public String handlinDynamicXpath(WebDriver driver) throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		HashMap<String, String> hMap = eLib.readMUltipleData("CreateTransactionByUser");
		String cFirstNme = hMap.get("cFirstNme");
		String cLastNme = hMap.get("cLastNme");
		String fullName=cFirstNme+" "+cLastNme;

		String txt = driver.findElement(By.xpath("//h6[contains(.,'"+fullName+"')]")).getText();
		return txt;
	}


}
