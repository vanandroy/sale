package com.GenericUtilities;

import java.io.File;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a generic class for all webdriver method
 * @author Vivekanand
 *
 */
public class WebDriverUtility 
   {
	/**
	 * This method is used to maximize the window
	 * @author Vivekanand
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait untill page load
	 * @param driver
	 * @author Vivekanand
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait for page load
	 * @author Vivekanand
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method will select from dropdown using value
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will select from dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will select from dropdown using visibleText
	 * @param element
	 * @param visibleText
	 */
	public Select selectByVisibleText(String visibleText,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
		return s;
	}
	/**
	 * This method is used to select first selected options
	 * @param element
	 * @param text
	 * @return
	 */
	public  String getFirstSelectedOPtion(WebElement element,String text) {
		Select s=new Select(element);
		s.getFirstSelectedOption();
		return text;
	}
	/**
	 * This method will perform Mouse Hover Action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	/**
	 * This method will perform Drag and Drop Action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dst);
	}
	/**
	 * This method will perform Double click Operation on webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * This method will perform Right Click on web page
	 * @param driver
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method will press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws Throwable
	 */
   	public void enterRelease(WebDriver driver) throws Throwable
   	{
   		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
   	}
   	/**
   	 * This method will switch the framebased on index
   	 * @param driver
   	 * @param index
   	 */
   	public void switchToFrame(WebDriver driver,int index)
   	{
   		driver.switchTo().frame(index);
   	}
   	/**
   	 * This method will switch the framebased on Name or ID
   	 * @param driver
   	 * @param nameorID
   	 */
   	public void switchToFrame(WebDriver driver,String nameorID)
   	{
   		driver.switchTo().frame(nameorID);
   	}
   	/**
   	 * This method will switch the framebased on address
   	 * @param driver
   	 * @param address
   	 */
   	public void switchToFrame(WebDriver driver,WebElement address)
   	{
   		driver.switchTo().frame(address);
   	}
   	/**
   	 * This method is used to accept alert popup
   	 * @param driver
   	 */
   	public void acceptAlert(WebDriver driver)
   	{
   		driver.switchTo().alert().accept();
   	}
   	/**
   	 * This method is used to cancel alert popup
   	 * @param driver
   	 */
   	public void cancelAlert(WebDriver driver)
   	{
   		driver.switchTo().alert().dismiss();
   	}
   	/**
   	 * This method is used to handle WindowHandles
   	 * @param driver
   	 * @param partialTitle
   	 */
   	public void switchToWindowHandles(WebDriver driver,String partialTitle)
   	{
   		//step1: use getWindowHandle to capture all window id's
   		Set<String> windows = driver.getWindowHandles();
   		//step2: Iterate through the window
   		Iterator<String> it = windows.iterator();
   		//step3: check wheather there is a next window id
   		while(it.hasNext())
   		{
   			//step4: capture current window id
   		     String winId=it.next();
   		     //step5: switch to current window and capture title
   		     String currentWinTitle = driver.switchTo().window(winId).getTitle();
   		     //step6: check wheather current window is expected
   		     if(currentWinTitle.contains(partialTitle))
   		     {
   		    	 break;
   		     }
   		}
   	}
   	/**
   	 * This method is used to handle the window handle
   	 * @param driver
   	 */
   	public void switchToWindowHandle(WebDriver driver)
   	{
   		String wh = driver.getWindowHandle();
   		driver.switchTo().window(wh);
   	}
   	/**
   	 * This method will take screenshot and store it in folder called as screenshot
   	 * @param driver
   	 * @param screenShotName
   	 * @return
   	 * @throws Throwable
   	 */
   	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
   	{
   		TakesScreenshot ts=(TakesScreenshot) driver;
   		File src=ts.getScreenshotAs(OutputType.FILE);
   		String path=".\\screenshot\\"+screenShotName+".png";
   		File dst=new File(path);
   		FileUtils.copyFile(src, dst);
		return path;
   	}
   	/**
   	 * this method will perform random scroll
   	 * @param driver
   	 */
   	public void scrollBarAction(WebDriver driver)
   	{
   		JavascriptExecutor jse=(JavascriptExecutor) driver;
   		jse.executeScript("window.scrollBy(0,800)", "");
   	}
   	/**
   	 * This method will scroll untill-specified element is found
   	 * @param driver
   	 * @param element
   	 */
   	public void scrollAction(WebDriver driver,WebElement element)
   	{
   		JavascriptExecutor jse=(JavascriptExecutor) driver;
   		int y=element.getLocation().getY();
   		jse.executeScript("window.scrollBy(0,"+y+")", element);
   		//jse.executeScript("argument[0].scrollIntoView()", element);  	
   	}
}
