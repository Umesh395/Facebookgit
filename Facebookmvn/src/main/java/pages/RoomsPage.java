package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {

    
    
    
	@FindBy (xpath = "//a[@href='https://messenger.com/']")	
	private WebElement returnToMassenger;
	
	@FindBy (xpath = "//a[@href='https://www.messenger.com/help']")
	private WebElement helpCentre;
	
	
	public RoomsPage(WebDriver driver){
		PageFactory.initElements(driver,this); 
	}
	
	public void goBackToMassenger() {
		returnToMassenger.click();
	}
	public void contactToHelpCentre() {
		helpCentre.click();
		
	}
	
	
	
	
	
	
	
}
