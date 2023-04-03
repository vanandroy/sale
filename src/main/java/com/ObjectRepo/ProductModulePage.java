package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class ProductModulePage {
	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary']//i[@class='fas fa-fw fa-plus']")
	private WebElement clkOnPlus;
	@FindBy(xpath="//input[@name='prodcode']")
	private WebElement prodId;
	@FindBy(xpath="//input[@name='name']")
	private WebElement prodNme;
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement prodDesc;
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement prodQuant;
	@FindBy(xpath="//input[@name='onhand']")
	private WebElement onHandPdt;
	@FindBy(xpath="//input[@name='price']")
	private WebElement pdtPrice;
	@FindBy(xpath="//select[@name='category']")
	private WebElement slctCategory;
	@FindBy(xpath="//select[@name='supplier']")
	private WebElement slctSupplier;
	@FindBy(xpath="//input[@name='datestock']")
	private WebElement slctDate;
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']//button[@class='btn btn-success']")
	private WebElement clkSubmit;
	
	public ProductModulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getClkOnPlus() {
		return clkOnPlus;
	}
	public WebElement getpId() {
		return prodId;
	}
	public WebElement getpNme() {
		return prodNme;
	}
	public WebElement getpDesc() {
		return prodDesc;
	}
	public WebElement getpQuant() {
		return prodQuant;
	}
	public WebElement getOnHandPdt() {
		return onHandPdt;
	}
	public WebElement getPdtPrice() {
		return pdtPrice;
	}
	public WebElement getSlctCategory() {
		return slctCategory;
	}
	public WebElement getSlctSupplier() {
		return slctSupplier;
	}
	public void clickOnPlusIcon() {
		clkOnPlus.click();
	}
	public void enterProductId(String pId) {
		prodId.sendKeys(pId);
	}
	public void enterProductName(String p2) {
		prodNme.sendKeys(p2);
	}
	public void enterProductDescription(String descp) {
		prodDesc.sendKeys(descp);
	}
	public void enterQuantity(String qty) {
		prodQuant.sendKeys(qty);
	}
	public void enterOnHandQuant(String qty) {
		onHandPdt.sendKeys(qty);
	}
	public void enterProductPrice(String price)
	{
		pdtPrice.sendKeys(price);
	}
	WebDriverUtility wdr=new WebDriverUtility();
	public void selectCategory(String text) {
		wdr.selectByVisibleText(text, slctCategory);	
	}
	public void selectSupplier(String text) {
		wdr.selectByVisibleText(text, slctSupplier);
	}
	public WebElement getSlctDate() {
		return slctDate;
	}
	public void selectDate(String text)
	{
		slctDate.click();
		slctDate.sendKeys(text);
	}
	public WebElement getClkSubmit() {
		return clkSubmit;
	}
	public void setClkSubmit(WebElement clkSubmit) {
		this.clkSubmit = clkSubmit;
	}
	public void clickOnSubmit() {
		clkSubmit.click();
	}
	
}
