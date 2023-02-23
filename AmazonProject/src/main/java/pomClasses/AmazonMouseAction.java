package pomClasses;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMouseAction {
	
	
	//variables or WebElements xpath
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accAndList;
	
	
	@FindBy(xpath="//span[text()='Your Account']")
	private WebElement yourAcc;
	
	@FindBy(xpath="(//span[text()='Sign in'])[1]")
	private WebElement signInBtn;
	
	
	
	
	//Constructor
	
	private WebDriver driver;
	private Actions act;
	public AmazonMouseAction(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
	}
	
	  //Methods
      //MouseActions 
     public void clickAccountAndList() throws InterruptedException
     {
    	
    	
    	 act.moveToElement(accAndList).perform();
    	 JavascriptExecutor executor = (JavascriptExecutor)driver;
    	 executor.executeScript("arguments[0].click();", yourAcc);
    	 
    	 
    	 /*act.moveToElement(accAndList).build().perform();
    	 act.moveToElement(signInBtn).build().perform();
    	 signInBtn.click();
    	 */
    	 
		/*act.moveToElement(accAndList).build().perform();
		//Thread.sleep(3000);
		act.moveToElement(yourAcc).build().perform();
		//Thread.sleep(3000);
		yourAcc.click();
 		*/ 				
     }
     
     //to click on sign in
     public void clickSignIn()
     {
    	 act.moveToElement(accAndList).build().perform();
 		//Thread.sleep(3000);
    	 signInBtn.click();
     }
     
     
	
     
	
	
	
}
