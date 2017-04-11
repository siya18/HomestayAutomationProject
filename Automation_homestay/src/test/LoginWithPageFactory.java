package test;

import org.testng.annotations.Test;

import Assertions.AssertFunctions;
import DriverSetup.driversetup;



import org.testng.annotations.BeforeTest;


import PageFactory.*;
import TestData.Constant;
import TestData.ExcelUtils;

public class LoginWithPageFactory {

	
		
		Login objLogin;
		Logout objLogout;
		AssertFunctions objAssert;
		
		@BeforeTest
		public void Setup()
		{
			
			driversetup.Setup();
			
		}

		/*@Test(priority=0)
		public void test_Login_Page_For_GuestUser()
		{
			try {
				ExcelUtils.setExcelFile(Constant.TestDataSheetPath+Constant.TestDataFileName,"LoginForGuestUser");
			} catch (Exception e) {
				e.printStackTrace();
			}
			objLogin= new Login(driversetup.driver);
			objAssert=new AssertFunctions(driversetup.driver);
			objLogout= new Logout(driversetup.driver);
			int i=0;
			for (i=1;i<=5;i++)
			{
				
					String UName=ExcelUtils.getCellData(i, 1);
					String Password=ExcelUtils.getCellData(i, 2);
					objLogin.LoginWindowForGuest(UName, Password);
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					objAssert.Assert_for_Correct_Login();
					
					String Temp_URL=driversetup.driver.getCurrentUrl();
					
					if(Temp_URL.equalsIgnoreCase(AssertFunctions.URLAfterLogout_expected))
					{
						System.out.println("ERROR FACED DUE TO WRONG EMAIL OR PASSWORD");
						ExcelUtils.setCellData("Failed",i,3);
						System.out.println("REsult added");
						System.out.println("-----------------------------------------");
						System.out.println("-----------------------------------------");
						
					}
					
					else
					{
						objLogout.Logout_User();
						objAssert.Assert_for_Correct_Logout();
						//driversetup.closewindow();
						ExcelUtils.setCellData("Pass",i,3);
						System.out.println("Result added");
						System.out.println("-----------------------------------------");
						System.out.println("-----------------------------------------");
					
					}
					
					
				}
			
			driversetup.driver.quit();
		}*/
			
		
		
		@Test(priority=1)
		public void test_Login_Page_For_HostUser()
		{
			
			try {
				ExcelUtils.setExcelFile(Constant.TestDataSheetPath+Constant.TestDataFileName,"LoginForHostUser");
			} catch (Exception e) {
				e.printStackTrace();
			}
			objLogin= new Login(driversetup.driver);
			objAssert=new AssertFunctions(driversetup.driver);
			objLogout= new Logout(driversetup.driver);
			
		
			int i=0;
			for (i=1;i<=5;i++)
			{
				
					String UName=ExcelUtils.getCellData(i, 1);
					String Password=ExcelUtils.getCellData(i, 2);
					objLogin.LoginWindowForGuest(UName, Password);
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					objAssert.Assert_for_Correct_Login();
					
					String Temp_URL=driversetup.driver.getCurrentUrl();
					
					if(Temp_URL.equalsIgnoreCase(AssertFunctions.URLAfterLogout_expected))
					{
						System.out.println("ERROR FACED DUE TO WRONG EMAIL OR PASSWORD");
						ExcelUtils.setCellData("Failed",i,3);
						System.out.println("REsult added");
						System.out.println("-----------------------------------------");
						System.out.println("-----------------------------------------");
						
					}
					
					else
					{
						objLogout.Logout_User();
						objAssert.Assert_for_Correct_Logout();
						//driversetup.closewindow();
						ExcelUtils.setCellData("Pass",i,3);
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
	
		
}




