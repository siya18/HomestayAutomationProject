package DriverSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class driversetup {
	
	
	public static WebDriver driver=null;
	public static final String URL= "https://www.homestay.com/";
	
	
	public static void Setup()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		
	}
	
	public static void closewindow()
	{
		
		driver.close();
	}

}
