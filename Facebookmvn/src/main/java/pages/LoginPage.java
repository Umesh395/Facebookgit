package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Decleration
	@FindBy (xpath = "//input[@type='text']")
	private WebElement  userName;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//button[@name='login']")
	private WebElement loginButton;
	
	@FindBy (xpath ="//a[text()='Forgotten password?']")
	private WebElement forgottonpassword;
	
	
	
	@FindBy (xpath = "//a[@rel='async']")
	private WebElement  createNewAcc;
  
	@FindBy (xpath = "//a[text()='Messenger']")
	private WebElement massenger;
	
	
	//Initiolisation
	public LoginPage(WebDriver driver) {
	  PageFactory.initElements(driver,this);
  }
  
  
  //Use
	public void sendUserName (){	
	    userName.sendKeys("Umesha");	
	}
	
	public void sendPassword(){	
		password.sendKeys("Umesha@123");
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void openForgottonPage() {
		forgottonpassword.click();
		
	}

	public void clickOnCreateNewAcc() {
		createNewAcc.click();
	}

	public void openMassenger() {
		massenger.click();
		
	}


		
	}



		
	

	

