package Assertions;

import org.apache.commons.validator.EmailValidator;
import org.openqa.selenium.WebDriver;

import DriverSetup.driversetup;
import FieldValidations.LoginScreenValidations;
import PageFactory.Login;
import PageFactory.signup;



public class AssertFunctions {

	
	 WebDriver driver=driversetup.driver;
	 
	 public static String URLAfterLogin_expected="https://www.homestay.com/user/booking_requests/guest";
	 public static String URLAfterLogout_expected="https://www.homestay.com/";
	 public static String URLAfterSignUpForGuest_expected="https://www.homestay.com/listing/new";
	 public static String URLAfterSignUpForHost_expected="https://www.homestay.com/host";
	
	public AssertFunctions(WebDriver driver)
	{
		this.driver=driver;
	
	}
	
	public void Assert_for_Correct_Login()
	{ 
		String URLAfterLogin=driver.getCurrentUrl();
		
		
		if(URLAfterLogin.equalsIgnoreCase(URLAfterLogin_expected))
		{
			System.out.println("USER IS REDIREECTED TO ITS RESPECTIVE ACCOUNT'S PAGE");
		}
		else
		{	
			System.out.println("ERROR IS REPORTED AT LOGIN SCREEN");
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			int length=Login.Temp_pass_value.length();
			EmailValidator emailaddress=EmailValidator.getInstance();
			
			int ELength=Login.Temp_email_value.length();
			int PLength=Login.Temp_pass_value.length();
			
			
			if(ELength<1)
			{
				LoginScreenValidations.capturescreenshot(driver, "Email_field_is_Blank");
			}
			else if(PLength<1)
			{
				LoginScreenValidations.capturescreenshot(driver, "Password_field_is_Blank");
			}
			else if(length<6 && emailaddress.isValid(Login.Temp_email_value))	
			{
				LoginScreenValidations.capturescreenshot(driver, "Password_Length_is_Less_than_6Characters");	
			}
			else if(!emailaddress.isValid(Login.Temp_email_value) && length>6)	
			{
				LoginScreenValidations.capturescreenshot(driver, "Incorrect_Email");	
			}
			else
			{
				System.out.println("Something went wrong");
			}
			
			Login.clickonclosebutton();
		}
		
	}
	
	
	public void Assert_for_Correct_Logout()
	{
		String URLAfterLogout=driver.getCurrentUrl();
		if(URLAfterLogout.equalsIgnoreCase(URLAfterLogout_expected))
		{
			System.out.println("USER HAS LOGGED OUT OF THE ACCOUNT SUCCESSFULLY");
		}
		else
		{
			System.out.println("ERROR HAS OCCURED DURING LOGOUT PROCESS");
		}
	}
	
	public void Assert_for_Guest_Signup()
	{
		String URLAfterSignUpForGuest=driver.getCurrentUrl();
		if(URLAfterSignUpForGuest.equalsIgnoreCase(URLAfterSignUpForGuest_expected))
		{
			System.out.println("Guest User has signed up successfully");
		}
		else
		{
			System.out.println("Error occured");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int length=signup.Temp_pass_value.length();
			EmailValidator emailaddress=EmailValidator.getInstance();
		
			
					
			if(!emailaddress.isValid(signup.Temp_email_value) && length<6)
			{
				LoginScreenValidations.capturescreenshot(driver, "Invalid_Email_and_Password_length_is_lessthan6charcters");
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
				signup.clickonclosebutton();
			
			}
			else if(emailaddress.isValid(signup.Temp_email_value) && length<6 )
			{
				LoginScreenValidations.capturescreenshot(driver, "Password_is_less_thn_6_characters");
				signup.clickonclosebutton();
				
			}
			else
			{
				LoginScreenValidations.capturescreenshot(driver, "EmailId_is_invalid");
				signup.clickonclosebutton();
			}
			
		}
		
	}
	
	public void Assert_for_Host_Signup()
	{
		String URLAfterSignUpForHost=driver.getCurrentUrl();
		if(URLAfterSignUpForHost.equalsIgnoreCase(URLAfterSignUpForHost_expected))
		{
			System.out.println("Host User has signed up successfully");
		}
		else
		{
			System.out.println("Error occured");
		}
	}
	
}
