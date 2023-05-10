package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icc {
    
    public static void main(String[] args) throws Throwable {	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.property");
	Properties p=new Properties();
	p.load(fis);
	driver.get(p.getProperty("iccurl"));
	List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
	List<WebElement> ranks= driver.findElements(By.xpath("//tbody/tr/td[2]/preceding-sibling::td[1]"));
	List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[2]/following-sibling::td[1]"));
	List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[2]/following-sibling::td[2]"));
	List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[2]/following-sibling::td[3]"));
	System.out.println("Rank"+" "+"Team"+" "+"Match"+" "+"Point"+" "+"Rating");
	for(int i=0;i<teams.size();i++) {
		String rank=ranks.get(i).getText();
		String team= teams.get(i).getText();
		String  match=matches.get(i).getText();
		String point=points.get(i).getText();
		String rating=ratings.get(i).getText();
		System.out.println(rank+" "+team+" "+match+" "+point+" "+rating);
	}
	driver.close();
	}

}
