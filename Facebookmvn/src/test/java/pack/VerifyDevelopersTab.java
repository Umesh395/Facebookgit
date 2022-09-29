package pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import pages.LoginPage;

import pages.MassengerPage;
import pages.RoomsPage;
import setup.Base;
import utils.Utility;

public class VerifyDevelopersTab extends Base{
		
	private WebDriver driver;
	private MassengerPage massenger;
	private LoginPage loginpage;
	private SoftAssert soft;
	int testCaseID;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println(browserName);
		if(browserName.equals("Chrome")) {
			
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Firefox")) {
			
			driver = openFirefoxBrowser();
		}
		
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}		
					
				
		@BeforeClass
		public void createPOMObjects() {
			loginpage = new LoginPage(driver);
		    massenger = new MassengerPage(driver);
		}
		
		@BeforeMethod
		public void openMassenger() {
		   driver.get("https://www.facebook.com/");
		   loginpage.openMassenger();
	       soft = new SoftAssert();
		}
		
		@Test
		public void verifyDevelopersTab(){
			testCaseID=12330;
		   massenger.openDevelopers();
		   String url = driver.getCurrentUrl();
	       String title = driver.getTitle();
		   soft.assertEquals(url,"https://developers.facebook.com/products/messenger/");
		   soft.assertEquals(title,"Messenger Developer Tools for Business | Facebook for Developers");
          soft.assertAll();
		
		}
		
		@AfterMethod
		public void logoutFromApplication(ITestResult result) throws IOException {
			System.out.println("AfterMethod");
			if(result.getStatus()==ITestResult.FAILURE)
			{
			// TestCaseID;
			Utility.captureScreen(driver, testCaseID);
			}
		}
		
		@AfterClass
		public void cleareObjects() {
			loginpage = null;
		    massenger = null;
		}
	
		@AfterTest
		public void closeBrowser() {
			driver.close();
			driver=null;
			System.gc();       //garbage collector

		}
	
		
		
		
		
   }
	



