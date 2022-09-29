package maven3;

import java.io.IOException;
import java.util.ArrayList;
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
import maven_3.AmazonHomePage;
import maven_3.Redme9MobilePage;
import utils.Utility;

public class VerifyRedmeMobilePageUrl {

    private AmazonHomePage amazonHomePage ;
    private WebDriver driver ;
    private Redme9MobilePage mobile ;
    
    @Parameters("browser")
    @BeforeTest
	public void openBrowser(String browserName) {
    	
    if(browserName.equals("Chrome"))
    	{
    	  Base.openChromeBrowser();
        } 
    	
    if(browserName.equals("Firefox"))
    	{
	      Base.openFirefoxBrowser();
        } 
    	
    	
     }
    
    @BeforeClass
	public void createPOMobject() {
		
	    amazonHomePage = new AmazonHomePage(driver);
        mobile = new Redme9MobilePage(driver);

	}
	
	@BeforeMethod
	public void openAmazonHomePage() throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println("Before Method");
		driver.get("https://www.amazon.com/");
        Thread.sleep(20);
        String data = Utility.dataFromExelSheet("Sheet1", 2, 0);
	    amazonHomePage.enterInput(data);
	    
	    amazonHomePage.clickOnSearch();
        Thread.sleep(20);
        amazonHomePage.clickOnRedmiMobile();
       
	}
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("Test");
	  
	    ArrayList<String> arg = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(arg.get(0));
	    
        mobile.addToCart();
	    String url =   driver.getCurrentUrl();
	    String title = driver.getTitle();
        Thread.sleep(20);

        Assert.assertEquals(url, "vhbjjk");  
	} 
       // if(url.equals("jkjhk") && title.equals("ktyiuret"))
        //   {
        //System.out.println("PASS");
        //}
        //else
        //{
        //System.out.println("FAIL");
        //}
	   
	 @AfterMethod
		public void logOutFromApplication() {
			System.out.println("log out");
	 }
	
	  @AfterClass
	  public void  clearObject() {
		   
		   amazonHomePage = null;
	        mobile = null;
	  }
	  
	 @AfterTest
	 public void closeBrowser() {
		 
		 driver.close();
		 driver= null ;
		 System.gc(); //GARBAGE COLLECTOR
	 }
	   
	   
	}
	











