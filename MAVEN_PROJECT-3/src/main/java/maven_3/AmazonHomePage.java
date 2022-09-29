package maven_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

	private WebDriver driver ;
	
	@FindBy ( xpath="//input[@id='twotabsearchtextbox']") 
	private WebElement input;
	
	@FindBy ( xpath="//input[@id='nav-search-submit-button']") 
	private WebElement search;
	
	@FindBy ( xpath="//img[@data-image-index='2']")
	private WebElement redme9Mobile ;
	
    public  AmazonHomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	this.driver=driver ;
    }
    
     public void enterInput(String data)
    {
       input.sendKeys(data);
    }
	public void clickOnSearch()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOf(search));
	    search.click();
		    
	}
	public void clickOnRedmiMobile()
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver ;
		 js.executeScript("arguments[0].scrollIntoView(true)",redme9Mobile);
	     redme9Mobile.click();
	}
	
		    
	
}
