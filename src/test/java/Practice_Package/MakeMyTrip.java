package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	
      public static void main(String[] args) throws Throwable {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable notifiction");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
//    	  WebDriverManager.firefoxdriver().setup();
//      	WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.property");
		Properties p=new Properties();
		p.load(fis);
		driver.get(p.getProperty("mmturl"));

		//driver.findElement(By.xpath("//li[text()='Round Trip']")).click();
        driver.findElement(By.xpath("//span[text()='From']")).click();
		
	    driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
	    driver.findElement(By.xpath("//span[text()='To']")).click();
	    driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
	    
	    //paasing journey date
	    Date cdate=new Date();
		String []d=cdate.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date=d[2];
		String year=d[5];
		String travelDate=day+" "+month+" "+date+" "+year;
		System.out.println("Travel date :"+travelDate);
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		//passing return date
		/*String rday="Thu";
		String rmonth="Jun";
		String rdate="15";
		String ryear="2023";
		String returnDate=rday+" "+rmonth+" "+rdate+" "+ryear;
		System.out.println("Return date "+returnDate);
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		driver.findElement(By.xpath("//p[@data-cy='"+returnDate+"']")).click();

		
		for(;;) 
		{
			try {
				driver.findElement(By.xpath("//p[@data-cy='"+returnDate+"']")).click();
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}
		}
		*/
		
		//giving no.of traveller
		driver.findElement(By.xpath("//p[@data-cy='travellerText']/span/span")).click();
		driver.findElement(By.xpath("//div[@class='travellers gbTravellers']/div/ul/li[4]")).click();
	    driver.findElement(By.xpath("//div[@class='travellers gbTravellers']/div[1]/div/div[1]/ul/li[5]")).click();
		driver.findElement(By.xpath("//div[@class='travellers gbTravellers']/div[1]/div/div[2]/ul/li[3]")).click();
		driver.findElement(By.xpath("//div[@class='travellers gbTravellers']/div[1]/ul[2]/li[3]")).click();
	    driver.findElement(By.xpath("//button[text()='APPLY']")).click();
//	    WebElement fm1 = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
//	     driver.switchTo().frame(fm1);
	    driver.quit();
		
		 
		
	}

}
