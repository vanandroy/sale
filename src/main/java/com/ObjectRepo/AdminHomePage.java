package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(xpath="//span[.='Customer']")
	private WebElement clickOnCust;
	@FindBy(xpath="//a[@href='product.php']//span[text()='Product']")
	private WebElement clkProduct;
	@FindBy(xpath="//a[@href='transaction.php']")
	private WebElement clkTrans;
	@FindBy(xpath="//span[text()='Inventory']")
	private WebElement clkInvent;
	@FindBy(xpath="//ul[@class='navbar-nav ml-auto']/li[2]/a/span")
	private WebElement adminDpDwnClk;
	@FindBy(xpath="//a[@data-target='#logoutModal']")
	private WebElement logoutModal;
	@FindBy(linkText="Logout")
	private WebElement logoutClk;
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getClickOnCust() {
		return clickOnCust;
	}
	public WebElement getClkTrans() {
		return clkTrans;
	}
	public WebElement getClkProduct() {
		return clkProduct;
	}
	public WebElement getclkInvent() {
		return clkInvent;
	}
	public WebElement getLgoutDpDwnClk() {
		return adminDpDwnClk;
	}
	public WebElement getLogoutModal() {
		return logoutModal;
	}
	public WebElement getLogoutClk() {
		return logoutClk;
	}
	public void clickCustomerMod() {
		clickOnCust.click();
	}

	public void clickOnProductMod() {
		clkProduct.click();
	}
	public void clickOnInventoryMod() {
		clkInvent.click();
	}
	public void clickOnTransactionMod() {
		clkTrans.click();
	}
	public void logoutAdminHomePage() {
		adminDpDwnClk.click();
		logoutModal.click();
		logoutClk.click();
		
	}
	

}
