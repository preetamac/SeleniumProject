package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignInPage {
	
	

	
	
	
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emainlOrMobile;
    
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//a[contains(text(),'Create your Amazon account')]")
	private WebElement createAmazonAccnt;
	
	private WebDriver driver;
	public AmazonSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	


}
