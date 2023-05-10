package Practice_Package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkPractice {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://phptravels.com/");
		List<WebElement> listOfAllLink = driver.findElements(By.xpath("//a"));
		List<String> listOfLink = new ArrayList<>();
		List<String> brokenLinks = new ArrayList<>();
		for(WebElement webelement:listOfAllLink)
		{
			String link = webelement.getAttribute("href");
			if(link!=null) {
				if(link.contains("http")) {
					listOfLink.add(link);
				}else {
					brokenLinks.add(link+" =====> Not having Http protocol");
				}
			}
			else {
				brokenLinks.add(link+"====> Null");
			}
		}
		for(String link:listOfLink) {
			try {
				URL url = new URL(link);
				URLConnection urlCon=url.openConnection();
				HttpURLConnection httpUrlCon = (HttpURLConnection) urlCon;
				int statusCode = httpUrlCon.getResponseCode();
				String responseMsg = httpUrlCon.getResponseMessage();
				if(statusCode>=400) {
					brokenLinks.add(link+" ===> Status Code : "+statusCode+" Response Msg : "+responseMsg);
				}
			}catch(Exception e) {
				brokenLinks.add(link+" ===>Not Connected to server");
			}
		}
		System.out.println(brokenLinks);
		System.out.println(brokenLinks.size());
		driver.close();
	}
}
