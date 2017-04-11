package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import DriverSetup.driversetup;

public class Login {
	
	WebDriver driver=driversetup.driver ;
	public static  String Temp_pass_value;
	public static String Temp_email_value;
	
	@FindBy(xpath=".//*[@id='navbar_items']/ul/li[5]/a")
	public static WebElement LoginLink;
	
	
	@FindBy(xpath=".//*[@id='navbar_items']/ul/li[5]/ul/li[1]/a")
	public static WebElement GuestLoginLink;
	
	@FindBy(xpath=".//*[@id='navbar_items']/ul/li[5]/ul/li[2]/a")
	public static WebElement HostLoginLink;
	
	@FindBy(id="email")
	public static WebElement Email;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	public static WebElement LoginButton;
	
	@FindBy(xpath="//div[@id='navbar_items']/ul/li[3]/a")
	public static WebElement SelectUser;
	
	@FindBy(xpath="//div[@id='navbar_items']/ul/li[3]/ul/li[8]/a")
	public static WebElement Logout;
	
	@FindBy(className="close")
	public static WebElement CloseButton;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginLink()
	{
		LoginLink.click();
	}
	
	public void GuestLoginLink()
	{
		GuestLoginLink.click();
	}
	
	public void HostLoginLink()
	{
		HostLoginLink.click();
	}
	
	public void EnterEmail(String EAddress)
	
	{ 	Email.clear();
		Email.sendKeys(EAddress);
	}
	public void EnterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void ClickOnLoginButton()
	{
		LoginButton.submit();
				
	}
	public static void clickonclosebutton()
	{
		CloseButton.click();
	}
	
	public void LoginWindowForGuest(String Email, String Password) {
		
		Temp_pass_value=Password;
		Temp_email_value=Email;
		this.LoginLink();
		this.GuestLoginLink();
		this.EnterEmail(Email);
		this.EnterPassword(Password);
		this.ClickOnLoginButton();
	}
	
	public void LoginWindowForHost(String Email, String Password) {
		
		Temp_pass_value=Password;
		Temp_email_value=Email;
		this.LoginLink();
		this.HostLoginLink();
		this.EnterEmail(Email);
		this.EnterPassword(Password);
		this.ClickOnLoginButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
