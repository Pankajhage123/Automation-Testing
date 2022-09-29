package maven_3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	
	@FindBy ( xpath="//input[@id='email']") 
	private WebElement userName;
	
	@FindBy ( xpath="//input[@id='pass']") 
	private WebElement passwordButton;
	
	@FindBy ( xpath="//button[text()='Log In']")
	private WebElement loginButton ;
	
    @FindBy ( xpath="//a[text()='Messenger']") 
	private WebElement messenger;
	
	public Login_Page ( WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}
	
	public void sendUserName ()
	{
		userName.sendKeys("pankajhage21@gmail.com");
	}
	
	public void sendPassword ()
	{
		passwordButton.sendKeys("Pankaj@123");
	}
	
	
	public void clickOnLoginButton ()
	{
		loginButton.click();
	}
	
	public void messenger ()
	{
		messenger.click();
	}
	
	//OR
	
	public void loginFacebook ()
	{
		userName.sendKeys();
		passwordButton.sendKeys();
		loginButton.click();
		}
}
	
	
	
	
	
	

