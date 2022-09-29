package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver  driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		 System.setProperty("webdriver.gecko.driver","C:\\Automation\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver() ;
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 return driver;
	}
	
	
	
	
	
}



