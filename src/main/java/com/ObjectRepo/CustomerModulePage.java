package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class CustomerModulePage {
	@FindBy(xpath="//a[@data-target='#customerModal']/i")
	private WebElement clkOnPlusIcon;
	@FindBy(name="firstname")
	private WebElement enterFirstName;
	@FindBy(name="lastname")
	private WebElement enterLastName;
	@FindBy(name="phonenumber")
	private WebElement enterPhoneNumber;
	@FindBy(xpath="//form[@action='cust_transac.php?action=add']/button[@type='submit']")
	private WebElement clkOnSubmit;
	@FindBy(xpath="//div[@id='dataTable_filter']//label")
	private WebElement searchTextBox;
	@FindBy(xpath="//tbody//tr[1]/td[3]")
	private WebElement searchResult;
	public CustomerModulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getClkOnPlusIcon() {
		return clkOnPlusIcon;
	}
	public void clickOnPlusIcon() {
		clkOnPlusIcon.click();
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
		return clkOnSubmit;
	}
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	public WebElement getSearchResult() {
		return searchResult;
	}
	public void enterFirstNme(String cFirstNme) {
		enterFirstName.sendKeys(cFirstNme);
	}
	public void enterLastNme(String cLastNme) {
		enterLastName.sendKeys(cLastNme);
	}
	public String enterPhoneNmr(String phoneNumber) {
		enterPhoneNumber.sendKeys(phoneNumber);
		return phoneNumber;
	}
	public void clickOnSubmit() {
		clkOnSubmit.click();
	}
	public void enterSearchTextBox(String phoneNumber) {
		searchTextBox.sendKeys(phoneNumber);
	}
	public String searchResult() {
		return searchResult.getText();
	}
	
	
	
}
