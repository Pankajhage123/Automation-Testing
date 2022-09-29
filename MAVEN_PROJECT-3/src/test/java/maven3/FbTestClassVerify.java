package maven3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import maven_3.Login_Page;
import maven_3.MessengerPagee;
import maven_3.RoomsPage;

public class FbTestClassVerify {
	
	 public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.get("https://www.facebook.com/");
			
	        Login_Page loginPage = new Login_Page(driver);
			loginPage.messenger();
			
			MessengerPagee messenger = new MessengerPagee (driver);
			messenger.openRoom();
			
			RoomsPage roomPage = new RoomsPage(driver);
			roomPage.visitHelpCenter();
			
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			
			if(url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre"))
			{
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
			
            driver.get("https://www.facebook.com/");
			
	    //    Login_Page loginPage = new Login_Page(driver);
			loginPage.messenger();
			
		//	MessengerPagee messenger = new MessengerPagee (driver);
			messenger.openRoom();
			
			RoomsPage roomPage1 = new RoomsPage(driver);
			roomPage.returnToMessenger();
			
			String url1 = driver.getCurrentUrl();
			String title2 = driver.getTitle();
			
			if(url1.equals("https://www.messenger.com/messenger") && title2.equals("Messenger "))
			{
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
			
			
			
			
	 }	 
			
			
	 }	 
	 
