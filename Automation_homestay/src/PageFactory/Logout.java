package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverSetup.driversetup;

public class Logout {

	WebDriver driver=driversetup.driver;
	
	@FindBy(xpath="//div[@id='navbar_items']/ul/li[3]/a")
	WebElement SelectUser;
	
	@FindBy(xpath="//div[@id='navbar_items']/ul/li[3]/ul/li[8]/a")
	WebElement Logout;
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnUserName()
	{
		SelectUser.click();
	}
	
	public void LogoutLink()
	{
		Logout.click();
	}
	
	public void Logout_User()
	{
		this.ClickOnUserName();
		this.LogoutLink();
	}
	
	
	

}
