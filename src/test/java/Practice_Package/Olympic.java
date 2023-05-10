package Practice_Package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com/en/");
		driver.findElement(By.xpath("//span[text()='Athletes']")).click();
		List<WebElement> nme = driver.findElements(By.xpath("//ul[@class='search--list row']/descendant::article/a/div"));
		List<WebElement> cntr = driver.findElements(By.xpath("//ul[@class='search--list row']/descendant::article/div/span"));
		 List<WebElement> rgn = driver.findElements(By.xpath("//ul[@class='search--list row']/descendant::article/div/span[2]"));
		System.out.println("Name Of Player"+"  "+" country "+"  "+" Region ");
		 for(int i=0;i<nme.size();i++) {
			String name=nme.get(i).getText();
			String country=cntr.get(i).getText();
			String region=rgn.get(i).getText();
			System.out.println(name+"        "+country+"         "+region);
			
		}
		driver.close();
	}

}
