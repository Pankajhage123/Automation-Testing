package maven3;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import maven_3.AmazonHomePage;
import maven_3.Redme9MobilePage;

public class AzonTestClass {
	
 public static void main(String[] args) {
		
    System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver() ;
	
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    
    AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
  //  amazonHomePage.enterInput();
    amazonHomePage.clickOnSearch();
    amazonHomePage.clickOnRedmiMobile();
    
    ArrayList<String> arg = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(arg.get(1));
    
    Redme9MobilePage redme9MobilePage = new Redme9MobilePage(driver);
    redme9MobilePage.addToCart();
    }
}
	
	
	

