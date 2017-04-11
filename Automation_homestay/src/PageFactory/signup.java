package PageFactory;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverSetup.driversetup;



public class signup {
	
	WebDriver driver=driversetup.driver;
	public static  String Temp_pass_value;
	public static String Temp_email_value;
	
	@FindBy(xpath=".//*[@id='navbar_items']/ul/li[4]/a")
	public static WebElement SignupLink;
	
	
	@FindBy(xpath=".//*[@id='navbar_items']/ul/li[4]/ul/li[1]/a")
	public static WebElement GuestSignUpLink;
	
	@FindBy(xpath=".//*[@id='navbar_items']/ul/li[4]/ul/li[2]/a")
	public static WebElement HostSignUpLink;

	@FindBy (id="user_first_name")
	public static WebElement FName;

	@FindBy (id="user_last_name")
	public static WebElement LName;
	
	@FindBy (id="user_email")
	public static WebElement Email;
	
	@FindBy (id="user_password")
	public static WebElement Password;
	
	@FindBy (id="user_want_to_host")
	public static WebElement Checkbox;
	
	@FindBy(id="select2-chosen-1")
	public static WebElement Prefix;
	
	@FindBy(id="s2id_autogen1_search")
	public static WebElement ENterCountryName;
	
	@FindBy(id="select2_results-1")
	public static WebElement SelectCountry ;
	
	
	@FindBy(id="user_telephone_number")
	public static WebElement Telephone;
	
	@FindBy(id="user_tcs")
	public static WebElement CheckboxForHostSignUp;
	
	@FindBy (xpath="//input[@value='Create Account']")
	public static WebElement CreateAccount;
	
	
	
	@FindBy(className="close")
	public static WebElement CloseButton;
	
	
	
	public signup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void SignupLink()
	{
		SignupLink.click();
	}
	
	public void GuestSignUpLink()
	{
		GuestSignUpLink.click();

	}
	
	public void HostSignUpLink()
	{
		HostSignUpLink.click();

	}
	
	public void  setFirstName(String FirstName)
	{
		FName.sendKeys(FirstName);
	}
	
	public void setLastName(String LastName)
	{
		LName.sendKeys(LastName);
	}
	
	public void setEmail(String Email)
	
	{
		signup.Email.sendKeys(Email);
	}
	
	public void setPassword(String password)
	{
		Password.sendKeys(password);
		
	}
	
	public void selectCountry()
	{
		Prefix.click();
		ENterCountryName.sendKeys("India");
		ENterCountryName.sendKeys(Keys.ARROW_DOWN);
		ENterCountryName.sendKeys(Keys.ENTER);
	}
	public void setPhoneNumber(String PN)
	
	{
		Telephone.sendKeys(PN);
	}
	
	public void ConfirmCheckBoxForGuest()
	{
		
		Checkbox.click();
	}
	
	
	public void ConfirmCheckboxForHost()
	{
		CheckboxForHostSignUp.click();
	}
	
	
	
	
	public void Confirm()
	{
		CreateAccount.submit();
	}
	
	public static void clickonclosebutton()
	{
		CloseButton.click();
	}
	
	public void SignupForGuest(String FirstName, String LastName, String Email, String password)
	{
		Temp_pass_value=password;
		Temp_email_value=Email;
		this.SignupLink();
		this.GuestSignUpLink();
		
		this.setFirstName(FirstName);
		this.setLastName(LastName);
		this.setEmail(Email);
		this.setPassword(password);
		
		
		this.ConfirmCheckBoxForGuest();
		this.Confirm();	
	}
	
	public void SignupForHost(String FirstName, String LastName, String Email, String password, String PN)
	{ 
		
		this.SignupLink();
		this.HostSignUpLink();
		
		this.setFirstName(FirstName);
		this.setLastName(LastName);
		this.setEmail(Email);
		this.setPassword(password);
		
		this.selectCountry();
		this.setPhoneNumber(PN);
		
		this.ConfirmCheckboxForHost();
		this.Confirm();
	
	
		
		
	}

	

}
