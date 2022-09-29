package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MassengerPage {

	
	
	
	@FindBy(xpath = "//a[text()='Rooms']")
	private WebElement room;
	
	@FindBy (xpath = "//a[@href='https://www.messenger.com/features']")
	private WebElement feature;
	
	@FindBy(xpath = "//a[text()='For developers']")
	private WebElement developers;
	
	public MassengerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void openRooms() {
		room.click();
	}
	
	
	public void openfeature() {
		feature.click();
	}
	
	public void openDevelopers() {
		developers.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
