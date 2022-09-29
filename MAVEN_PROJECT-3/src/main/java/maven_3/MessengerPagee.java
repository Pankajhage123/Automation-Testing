package maven_3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPagee  {

	@FindBy ( xpath="//a[text()='Rooms']")
	private WebElement room ;
	
	@FindBy ( xpath="//a[text()='Features']") 
	private WebElement feature;
	
	
	
	public MessengerPagee(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openRoom()
	{
		room.click();
	}
	
	
	
	
}
