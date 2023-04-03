package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Sales.property");
	    Properties p=new Properties();
	    p.load(fis);
	    String BROWSER = p.getProperty("browser");
	    String URL=p.getProperty("url");
	    String USER_NAME=p.getProperty("username");
	    String PASSWORD=p.getProperty("password");
	    System.out.println(BROWSER);
	    System.out.println(URL);
	    System.out.println(USER_NAME);
	    System.out.println(PASSWORD);
	    
	}

}
