package pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import pages.ForgottonPasswordPage;
import pages.LoginPage;
import setup.Base;
import utils.Utility;

public class VerifySubmitAndCancelButton extends Base {

	private WebDriver driver;
	LoginPage loginPage;
	private ForgottonPasswordPage forgottonPasswordPage ;
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
		
	     loginPage = new LoginPage(driver);
		 forgottonPasswordPage = new ForgottonPasswordPage(driver);
	}
	
	@BeforeMethod
	public void openForgottonPassword() throws InterruptedException {
	   driver.get("https://www.facebook.com/");
    	loginPage.openForgottonPage();
	   Thread.sleep(3000);
	   soft = new SoftAssert();
	}
	
	@Test(priority=1)
	public void verifySerchButton() throws InterruptedException {
		testCaseID=45444;
	   forgottonPasswordPage.showFillInErrorMessege();
	   Thread.sleep(2000);
	   soft.assertEquals(forgottonPasswordPage.showErrorMassege(), true);
	   soft.assertAll();
	} 
	
	@Test(priority=2)
	public void verifyCancelButton() {
		testCaseID=22445;
	   forgottonPasswordPage.showLoginPopup();
	   String url = driver.getCurrentUrl();
	   String title = driver.getTitle();
	   soft.assertEquals(url,"https://www.facebook.com/login.php");
	   soft.assertEquals(title,"Log in to Facebook");
	   soft.assertAll();
	}
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException {
		System.out.println("AfterMethod");
		//if(ITestResult.FAILURE==result.getStatus())
	//	{
		   Utility.captureScreen(driver, testCaseID);
		//}
	}
	
	@AfterClass
	public void clearObjects() {
    	System.out.println("AfterClass");              
    	 loginPage = null;
    	 forgottonPasswordPage = null;
    }
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
    	System.gc();

	}
	
	
	
	
	
}
