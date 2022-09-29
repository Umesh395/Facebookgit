package pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.bouncycastle.jcajce.provider.symmetric.Grainv1.Base;
//import org.bouncycastle.jcajce.provider.symmetric.Grain128.Base;
//import org.bouncycastle.jcajce.provider.symmetric.ChaCha.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import pages.LoginPage;
import pages.MassengerPage;
import pages.RoomsPage;
import setup.Base;
import utils.Utility;

public class VerifyRoomPage extends Base{
		
	private WebDriver driver;
    private LoginPage loginPage;
    private RoomsPage roomsPage;
    private MassengerPage massengerPage;
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
	public void createPMObjects() {
        loginPage = new LoginPage(driver);
        massengerPage = new MassengerPage(driver);
        roomsPage = new RoomsPage(driver);

	}
		
	@BeforeMethod
	public void openRoomsPage() {
		driver.get("https://www.facebook.com/");
        loginPage.openMassenger();    
         massengerPage.openRooms();
	    soft = new SoftAssert();

	}
	
	@Test(priority=1)
	public void verifyContactToHelpCentreButton() {
		testCaseID=11223;
		System.out.println("verifyContactToHelpCentreButton");
		roomsPage.contactToHelpCentre();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		soft.assertEquals(url,"https://www.messenger.com/help");
		soft.assertEquals(title,"Messenger Hlep Centre");
        
		soft.assertAll();
	}
	
	@Test(priority=2)
	public void verifyGoBackToMassengerButton() {
		testCaseID=11255;

	    System.out.println("verifyGoBackToMassengerButton");
		roomsPage.goBackToMassenger();
		String url1 = driver.getCurrentUrl();
		String title1 = driver.getTitle();
		soft.assertEquals(url1,"https://www.messenger.com/");
  		soft.assertEquals(title1,"Messenger");
		
  		soft.assertAll();

		}
	
	@AfterMethod 	
	public void logoutFromApplication(ITestResult result) throws IOException {                //if need then take this otherwise no need
		System.out.println("After Method");
		if(ITestResult.FAILURE==result.getStatus())
		{
		// TestCaseID;
		Utility.captureScreen(driver, testCaseID);
		}
	}
		
    @AfterClass
	public void clearObjects() {
    	System.out.println("AfterClass");              
    	 loginPage = null;
         massengerPage =null;
         roomsPage = null;
    }

    @AfterTest
    public void closeBrowser(){
    	System.out.println("AfterTest");
    	driver.close();
    	System.gc();
    }
	
	

	}	
	
	
	
