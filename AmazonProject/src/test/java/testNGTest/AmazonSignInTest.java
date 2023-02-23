package testNGTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.BrowserSetUp;
import pomClasses.AmazonMouseAction;
import pomClasses.YourAccountPage;
import utils.Utility;

public class AmazonSignInTest extends BrowserSetUp{
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
		driver.get("https://www.amazon.com/");
		testMethodName=method.getName();
		//System.out.println(testMethodName);
		System.out.println("Before Method");
		
		
		}
	
	
	
	
	//ToFetch data from excelsheet
	
	@DataProvider
	public String getSignIndata() throws EncryptedDocumentException, IOException
	{
		String us=Utility.fetchDataFromExcelSheet("AmazonLogin", 1, 0);
		return us;
	}
	
	@Test(dataProvider="getSignIndata")
	public void signIn(String u,String p) throws IOException
	{
		
		amazonMouseAction.clickSignIn();
		//user=Utility.fetchDataFromExcelSheet("Amazonlogin", 1, 0);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(u);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Utility.CaptureScreenShot(driver,testMethodName);
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
