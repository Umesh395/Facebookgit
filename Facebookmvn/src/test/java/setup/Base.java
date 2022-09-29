package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

public static WebDriver  openChromeBrowser() {
		
		System.out.println("Chrome");
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91880\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
		}
		
	public static WebDriver openFirefoxBrowser() {
		System.out.println("Firefox");

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\91880\\OneDrive\\Documents\\Automation\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			 WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return driver;
			
		}
	
	
	
}
