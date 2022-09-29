package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottonPasswordPage {

	@FindBy (xpath = "//button[@id='did_submit']")
	private WebElement submitButton;
	
	@FindBy (xpath = "//div[text()='Please fill in at least one field']")
	private WebElement error;
	
	
	@FindBy (xpath = "//a[@role='button']")
	private WebElement cancelButton;
	
	
	public ForgottonPasswordPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	public void showFillInErrorMessege() {
		submitButton.click();
	}
	public boolean showErrorMassege() {
		return error.isDisplayed();
	}
	
	public void showLoginPopup() {
		cancelButton.click();
		
	}
	
	
	
	
	
	
}
