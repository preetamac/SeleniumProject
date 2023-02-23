package testNGTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.BrowserSetUp;
import pomClasses.AmazonAddingItemToCart;
import utils.Utility;

public class TestNGClass extends BrowserSetUp{
	
	WebDriver driver;
	AmazonAddingItemToCart amazonAddingItemToCart;
	String testMethodName;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
		{
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		if(browserName.equals("Firefox"))
		{
			driver=openFireFoxBrowser();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Before Test");
		}
	
	@BeforeClass
	public void createObject()
	{
		amazonAddingItemToCart=new AmazonAddingItemToCart(driver);
	}
	@BeforeMethod
	public void launchAmazonURL(Method method)
		{
		driver.get("https://www.amazon.in/");
		testMethodName=method.getName();
		
		System.out.println(testMethodName);
		
		}
	
	@Test
	public void addToCartTest1() throws InterruptedException, IOException
		{
		
		amazonAddingItemToCart.clickOnDeals();
		Thread.sleep(2000);
		amazonAddingItemToCart.clickOnMobiles();
		Thread.sleep(2000);
		amazonAddingItemToCart.clickOnBestDeals();
		Thread.sleep(2000);
		amazonAddingItemToCart.clickOnRate();
		Thread.sleep(2000);
		amazonAddingItemToCart.selectCheckBox();
		Thread.sleep(2000);
		amazonAddingItemToCart.selectMobileAndClick();
		Thread.sleep(2000);
		//to select sub category
		amazonAddingItemToCart.selectMobile();
		amazonAddingItemToCart.clickOnAddToCart();
		Thread.sleep(2000);
		amazonAddingItemToCart.checkOut();
		Utility.CaptureScreenShot(driver, testMethodName);
		
		}
	
	@AfterMethod
	public void closeDriver()
		{
			System.out.println("After Method");
			driver.close();
		}
	
	@AfterClass
	public void afterClass()
		{
			System.out.println("After Class");
			amazonAddingItemToCart=null;
			
		}
	
	@AfterTest
	public void closeBrowser()
	{
		//driver.close();
		//driver=null;
		//System.gc();
	}
}
