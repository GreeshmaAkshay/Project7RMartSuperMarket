package testscriptclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage1;

public class HomeTest extends Base1{
	HomePage home;
	LoginPage1 login;
	@Test
	(dataProvider = "credentials")
	public void admin_Logout(String username ,String password) {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName(username).enterPassword(password);
		home = loginPage.signIn();//Login
		home.clickLogout();//------>Logout
		
	}
	@DataProvider(name = "credentials")
	public Object[][] testdata() {
	Object data[][] = { { "admin", "sdasd" }, { "admin", "admin" } };
		return data;
	}
	
}
