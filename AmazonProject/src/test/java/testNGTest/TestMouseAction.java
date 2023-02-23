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
import pomClasses.AmazonMouseAction;
import pomClasses.YourAccountPage;
import utils.Utility;
public class TestMouseAction extends BrowserSetUp {

	WebDriver driver;
	AmazonMouseAction amazonMouseAction;
	YourAccountPage yourAccountPage;
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
		System.out.println("Before Class");
		 amazonMouseAction=new AmazonMouseAction(driver); 
		 yourAccountPage=new YourAccountPage(driver);
	}
	
	@BeforeMethod
	public void launchAmazonURL(Method method )
		{
		driver.get("https://www.amazon.in/");
		testMethodName=method.getName();
		System.out.println(testMethodName);
		
		
		}
	
	
	
	@Test()
	public void gotoYourOrder() throws InterruptedException, IOException
		{
		//Mouse Action Commands
		
		 amazonMouseAction.clickAccountAndList();
		 Utility.CaptureScreenShot(driver,testMethodName);
		 yourAccountPage.clickOnYourOrder();
		 Utility.CaptureScreenShot(driver,testMethodName);
		}
	
	
	
	@AfterMethod
	public void closeDriver()
		{
			System.out.println("After Method");
			driver.close();
			
		}
	@AfterClass
	public void clearObject()
		{
			System.out.println("After Class");
			amazonMouseAction=null;
			yourAccountPage=null;
			
		}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
		//driverTest.quit();
		driver=null;
		System.gc();
	}
	

  
}
