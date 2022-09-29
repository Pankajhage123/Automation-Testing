package maven_3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {

	@FindBy ( xpath=" //a[text()=' Return to messenger.com ']")
	private WebElement returnToMessenger;
	
	@FindBy ( xpath=" //a[@href='https://www.messenger.com/help']") 
	private WebElement visitOurHelpCenter;
	
	
	
	public RoomsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void visitHelpCenter()
	{
		visitOurHelpCenter.click();
	}
	
	public void returnToMessenger()
	{
		visitOurHelpCenter.click();
	}
	
	
	
	
}
