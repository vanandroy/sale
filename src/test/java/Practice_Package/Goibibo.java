package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo {
	@Test
	public void goibibo() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disble notification--");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@class='sc-pVTFL gMNQJM']")).click();
        WebElement frm = driver.findElement(By.xpath("//div[@class='sc-ehCJOs dOUNaZ']/descendant::div[3]/p"));
		frm.click();
		frm.sendKeys("blr");
		//Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::p")).click();
//		Thread.sleep(3000);
		driver.quit();
		
	}
}
