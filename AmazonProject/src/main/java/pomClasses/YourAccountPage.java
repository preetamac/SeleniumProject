package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

	
	@FindBy(xpath="//span[text()='Track, return, or buy things again']")
	private WebElement yourOrders;
	
	private WebDriver driver;
	
	public YourAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	//Click on your order 
	public void clickOnYourOrder()
	{
		yourOrders.click();
	}
}
