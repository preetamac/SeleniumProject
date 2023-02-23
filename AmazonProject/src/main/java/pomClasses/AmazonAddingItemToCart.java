package pomClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAddingItemToCart {
	
	//variable
	@FindBy(xpath="//a[text()=\"Today's Deals\"]")
	private WebElement deals;
	
	@FindBy(xpath="//span[text()='Mobiles']")
	private WebElement mobiles;

	@FindBy(xpath="//span[text()='Best deal']")
	private WebElement bestdeal;

	@FindBy(xpath="(//span[text()='and up'])[1]")
	private WebElement rate;

	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	private WebElement checkBox;
	
	@FindBy(xpath="(//div[@data-csa-c-type='item'])[1]")
	private WebElement selectmobile;
	
	@FindBy (xpath="(//div[@class='a-section octopus-dlp-image-shield'])[1]")
	private WebElement selectMobileFromList;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addcart;
	
	@FindBy(xpath="//span[@id='attach-sidesheet-checkout-button']")
	private WebElement proceedToCheckOut;
	
	
	//constructor
	WebDriver driver;
	public AmazonAddingItemToCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	//Methods//perform actions
	public void clickOnDeals()
	{
		deals.click();
	}
	
	public void clickOnMobiles()
	{
		mobiles.click();
	}
	
	public void clickOnBestDeals()
	{
		bestdeal.click();
	}
	
	public void clickOnRate()
	{
		rate.click();
	}
	
	public void selectCheckBox()
	{
		boolean result=checkBox.isSelected();
		if(result==false)
		{
			checkBox.click();
		}
		
	}
	
	
	public void selectMobileAndClick()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(selectmobile));
		selectmobile.click();
	}
	
	public void selectMobile()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(selectMobileFromList));
		selectMobileFromList.click();
	}

	public boolean validateAddToCart()
	{
		return addcart.isDisplayed();
	}
	
	
	public void clickOnAddToCart()
	{
		addcart.click();
	}
	
	
	public void checkOut()
	{
		
		proceedToCheckOut.click();
		
	}

}



