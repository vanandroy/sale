package Practice_Package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TokyoOlympic {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		List<WebElement> cNme = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		List<WebElement> cMedal = driver.findElements(By.xpath("//span[@data-cy='country-name']/../following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div"));
	   System.out.println("country "+"    "+"Total Medals");
		for(int i=0;i<cNme.size();i++) {
	    	String CountName = cNme.get(i).getText();
	    	String countMedal = cMedal.get(i).getText();
	    	System.out.println(CountName+"       "+countMedal);
	    	
	    }
	driver.close();
	
	}
}
