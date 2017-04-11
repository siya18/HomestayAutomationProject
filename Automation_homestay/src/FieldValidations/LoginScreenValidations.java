package FieldValidations;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class LoginScreenValidations {
	
	
	public static void capturescreenshot(WebDriver driver, String ScreenShotName)
	{
		
		try
		{
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File F=ts.getScreenshotAs(OutputType.FILE);
			org.apache.commons.io.FileUtils.copyFile(F, new File("D:/Screenshot/"+ScreenShotName+".png"));;
			System.out.println("SCREENSHOT IS TAKEN SUCCESSFULLY OF" +ScreenShotName);
		
		}
		
		
		catch(Exception E)
		{
			System.out.println("Exception while taking screenshot" +E.getMessage());
		}
		
		
		
		
	}
	
	

}
