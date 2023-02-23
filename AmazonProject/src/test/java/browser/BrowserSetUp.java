package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetUp{
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arun\\OneDrive\\Desktop\\Testing_class\\chromedriver_win32 (1)110\\chromedriver.exe");
		WebDriver driverTest=new ChromeDriver();
		return driverTest;
		
	}
	
	public static WebDriver openFireFoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\arun\\OneDrive\\Desktop\\Testing_class\\geckodriver-v0.32.2-win32\\geckodriver.exe");
		WebDriver driverTest=new FirefoxDriver();
		return driverTest;
	}
}