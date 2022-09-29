package maven_3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Redme9MobilePage {

	  private WebDriver driver ;
	  
	  @FindBy ( xpath="//input[@id='add-to-cart-button']") 
	  private WebElement addToCart;
		
	  public Redme9MobilePage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
		  this.driver = driver ;
	  }
	  public void addToCart()
		{
		  JavascriptExecutor js1 = (JavascriptExecutor) driver ;
		  js1.executeScript("arguments[0].scrollIntoView(true)", addToCart);
		  addToCart.click();
		}

		
}
