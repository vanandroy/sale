package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPrice {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 14 plus");
	    driver.findElement(By.xpath("//form[@action='/search']/ul/li[1]")).click();
		String pName = driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 Plus (Blue, 128 GB)']")).getText();
	    String price = driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 Plus (Blue, 128 GB)']/../parent::div/div[2]/descendant::div/div/child::div[1]")).getText();
		System.out.println(pName+"  "+price);
		driver.quit();
	}

}
