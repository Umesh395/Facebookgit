package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static void captureScreen(WebDriver driver,int testCaseID ) throws IOException {
		
		Date date = new Date();
		DateFormat simple = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String currentdate =simple.format(date);
		System.out.println(currentdate);
		
		TakesScreenshot take = (TakesScreenshot)driver;
		File source = take.getScreenshotAs(OutputType.FILE);
		File destination = new File ("C:\\Users\\91880\\OneDrive\\Documents\\Automation\\Selenium\\Screenshots\\Test-"+testCaseID+" "+currentdate+".jpeg");		
		FileHandler.copy(source,destination);
		
	
	
	
	
	
	}
	
	
}
