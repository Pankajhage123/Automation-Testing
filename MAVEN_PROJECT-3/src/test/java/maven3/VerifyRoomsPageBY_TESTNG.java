package maven3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import maven_3.Login_Page;
import maven_3.MessengerPagee;
import maven_3.RoomsPage;
import utils.Utility;

public class VerifyRoomsPageBY_TESTNG extends Base {
      
	private WebDriver driver ;
	private Login_Page loginPage; 
	private RoomsPage roomPage ;
	private MessengerPagee messenger;
	public static int testId ;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		
		System.out.println(browserName);
		
		if(browserName.equals("Chrome")) 
		{	
		    driver=openChromeBrowser();
		}
		
		if(browserName.equals("Firefox")) 
		{	
			driver=openFirefoxBrowser();
  		}
	}
	
	@BeforeClass
	public void createPOMobject() {
		System.out.println("Before Class");
        loginPage = new Login_Page(driver);
	    messenger = new MessengerPagee (driver);
	    roomPage = new RoomsPage(driver);

	}
	
	@BeforeMethod
	public void openRoomPage() throws EncryptedDocumentException, IOException {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
	//	String username = "pankajhage21@gmail.com" ;
	//	String password = "Pankaj@123";
	
	//  String username = Utility.dataFromExelSheet("Sheet1", 1, 0);
	//	String password = Utility.dataFromExelSheet("Sheet1", 1, 1);
     //  loginPage.loginFacebook();

		
		loginPage.messenger();
		messenger.openRoom();
        
	}
	
	@Test
	public void toVerifyMessengerHelpCenterButton() {
		testId = 4568 ;
		System.out.println("Test1");
		roomPage.visitHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
	    
		Assert.assertEquals(url, "https://www.messenger.com/help");
		Assert.assertEquals(title, "Messenger Help Centre");
	}	
	/*	if(url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}*/
	
	
	@Test
	public void toVerifyReturnToMessengerButton() {
		testId = 7895 ;
		System.out.println("Test2");
		roomPage.returnToMessenger();
		
		String url1 = driver.getCurrentUrl();
		String title2 = driver.getTitle();
		
		Assert.assertEquals(url1, "https://www.messenger.com/messenger");
		Assert.assertEquals(title2, "Messengerrr");
	}
		
		
		
		/*if(url1.equals("https://www.messenger.com/messenger") && title2.equals("Messenger"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}  */
	
	
    @AfterMethod
	public void logOutFromApplication() {
		System.out.println("log out");

	}
    
    @AfterClass 
	public void clearPOMobject() {
		System.out.println("After Class");
		
	    loginPage = null;
	    MessengerPagee messenger = null;
	    roomPage = null;

	  }
	
    @AfterTest
    public void closeBrowser() {
    	System.out.println("Afer Test");
    	driver.close();
        System.gc(); //GARBAGE COLLECTOR
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

