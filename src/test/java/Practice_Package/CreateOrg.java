package Practice_Package;

import java.awt.Desktop.Action;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrg {

	public static void main(String[] args) {
		String expName="Octoban";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.partialLinkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Random ran = new Random();
		int random = ran.nextInt(1000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expName+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualOrg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrg.contains(expName)) {
			System.out.println("organisation successfully created");
		}
		else {
			System.out.println("organisation not created");
		}
		Actions a = new Actions(driver);
		WebElement admn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(admn).perform();
	   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
