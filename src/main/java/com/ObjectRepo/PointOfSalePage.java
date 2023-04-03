package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class PointOfSalePage {
	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement clkPlus;
	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//input[@name='firstname']")
	private WebElement enterFirstName;
	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//input[@name='lastname']")
	private WebElement enterLastName;
	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//input[@name='phonenumber']")
	private WebElement enterPhoneNumber;
	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//button[@type='submit']")
	private WebElement clkOnSubmitForCust;
	@FindBy(name="customer")
	private WebElement slctCust;
	@FindBy(xpath="//div[@class='btn bg-gradient-danger btn-danger']")
	private WebElement dlt;
	@FindBy(xpath="//button[text()='SUBMIT']")
	private WebElement clkSubmit;
	@FindBy(xpath="//input[@id='txtNumber']")
	private WebElement txn;
	@FindBy(xpath="//button[text()='PROCEED TO PAYMENT']")
	private WebElement payment;
	@FindBy(xpath="//h4[text()='Point of Sale']")
	private WebElement pos;
	public PointOfSalePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	WebDriverUtility wLib=new WebDriverUtility();
	public WebElement getClickOnPlusIcon() {
		return clkPlus;
	}
	public WebElement getEnterFirstName() {
		return enterFirstName;
	}
	public WebElement getEnterLastName() {
		return enterLastName;
	}
	public WebElement getEnterPhoneNumber() {
		return enterPhoneNumber;
	}
	public WebElement getClkOnSubmit() {
		return clkOnSubmitForCust;
	}
	public void clickOnPlusIcon() {
		clkPlus.click();
	}
	public void enterFirstName(String cFirstNme) {
		enterFirstName.sendKeys(cFirstNme);
	}
	public void enterLastName(String cLastNme) {
		enterLastName.sendKeys(cLastNme);
	}
	public String enterPhoneNumber(String phoneNumber) {
		enterPhoneNumber.sendKeys(phoneNumber);
		return phoneNumber;
	}
	public void clickOnSubmitForNewCust() {
		clkOnSubmitForCust.click();
	}
	
	public WebElement getSlctCustUser() {
		return slctCust;
	}
	public String selectCustFromDpDwn(String text)
	{
		wLib.selectByVisibleText(text,slctCust );
		return text;
	}
	public WebElement getDlt() {
		return dlt;
	}
	public void clickOnDelete() {
		dlt.click();
	}
	public WebElement getClkSubmit() {
		return clkSubmit;
	}
	public void clickOnSubmit() {
		clkSubmit.click();
	}
	public WebElement getTxn() {
		return txn;
	}
	public void enterCash(String txnNumber) {
		txn.sendKeys(txnNumber);
	}
	public WebElement getPayment() {
		return payment;
	}
	public void clickOnProceedPayment() {
		payment.click();
	}
	public WebElement getTitleOfUserPage() {
		return pos;
	}
	public String titleOfUserPage() {
		return pos.getText();
	}
	
	

}
