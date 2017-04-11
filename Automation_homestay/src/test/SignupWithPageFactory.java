package test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assertions.AssertFunctions;
import DriverSetup.driversetup;
import PageFactory.Logout;
import PageFactory.signup;
import TestData.Constant;
import TestData.ExcelUtils;

public class SignupWithPageFactory {
	
	public static WebDriver driver=null;
	
	
	signup objSignupPage;
	driversetup objdriversetup;
	AssertFunctions objAssert;
	Logout objLogout;
	
	@BeforeTest
	public static void Setup()

	{
		driversetup.Setup();
		/*driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.homestay.com/");
		driver.manage().window().maximize();*/
		
	}

	
		
	@Test(priority=0)
	public void test_sign_up_page_For_Guest()
	{
		try {
			ExcelUtils.setExcelFile(Constant.TestDataSheetPath+Constant.TestDataFileName,"SignUpForGuestUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		objSignupPage= new signup(driversetup.driver);
		objAssert=new AssertFunctions(driversetup.driver);
		objLogout.Logout_User();
		
		
		int i=0;
		for (i=1;i<=5;i++)
		{
			
				String FName=ExcelUtils.getCellData(i, 1);
				String LName=ExcelUtils.getCellData(i, 2);
				String Email=ExcelUtils.getCellData(i, 3);
				String Password=ExcelUtils.getCellData(i, 4);
				objSignupPage.SignupForGuest(FName, LName, Email, Password);
				
			
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				objAssert.Assert_for_Guest_Signup();
				
				String Temp_URL=driversetup.driver.getCurrentUrl();
				
				if(Temp_URL.equalsIgnoreCase(AssertFunctions.URLAfterLogout_expected))
				{
					System.out.println("ERROR FACED DUE TO WRONG EMAIL OR PASSWORD");
					ExcelUtils.setCellData("Failed",i,5);
					System.out.println("REsult added");
					System.out.println("-----------------------------------------");
					System.out.println("-----------------------------------------");
					
				}
				
				else
				{
					objLogout.Logout_User();
					objAssert.Assert_for_Correct_Logout();
					//driversetup.closewindow();
					ExcelUtils.setCellData("Pass",i,5);
					System.out.println("Result added");
					System.out.println("-----------------------------------------");
					System.out.println("-----------------------------------------");
				
				}
				
				
				
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
				
		}
		
				driversetup.driver.quit();
	}


		
//		//Correct email and password 
//		//objSignupPage.SignupForGuest("Shivangi", "Gohel", "siya18.engg@gmail.com", "Master@siya310112");
//		
//		//incorrect email and password
//		objSignupPage.SignupForGuest("Shivangi", "Gohel", "siya18", "Maste");
//
//			
//		//incorrect email and correct password
//		//objSignupPage.SignupForGuest("Shivangi", "Gohel", "siya18", "Mastersiya18");
//		
//		//incorrect password and correct mail
//		//objSignupPage.SignupForGuest("Shivangi", "Gohel", "shiva18@gmail.com", "Maste");
//		
//		
//		objAssert.Assert_for_Guest_Signup();
//		String Temp_URL=driversetup.driver.getCurrentUrl();
//		
//		if(Temp_URL.equalsIgnoreCase(AssertFunctions.URLAfterLogout_expected))
//		{
//			System.out.println("ERROR FACED DUE TO WRONG EMAIL OR PASSWORD");
//			driversetup.closewindow();
//		}
//		else
//		{
//			objLogout.Logout_User();
//			objAssert.Assert_for_Correct_Logout();
//			driversetup.closewindow();
//		
//		}
//		/*objLogout.Logout_User();
//		objAssert.Assert_for_Correct_Logout();*/
//		
//	}
	
	/*@Test(priority=1)
	public void test_sign_up_page_For_Host()
	{
		
		objSignupPage= new signup(driver);
		objSignupPage.SignupForHost("Siya", "Gohel", "Siya123@gmail.com", "Siya310112", "789446112");
		objAssert.Assert_for_Host_Signup();
		objLogout.Logout_User();
		objAssert.Assert_for_Correct_Logout();
		
	 
	 
	}*/

	
	
	
}
