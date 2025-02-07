package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;

public class HomeTest extends Base1{
	HomePage home;
	LoginPage1 login;
	@Test
	
	public void admin_Logout() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();//Login
		home.clickLogout();//------>Logout
		
		boolean isLoginpageIsLoaded = loginPage.isDashboardIsLoaded();
		Assert.assertTrue(isLoginpageIsLoaded,Constant.ERROR_MESSAGE_FOR_UNSUCCESSFUL_LOGOUT);
	}
	
	
}
