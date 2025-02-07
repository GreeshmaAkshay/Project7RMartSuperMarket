package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class LoginTest1 extends Base1 {
	HomePage home;
	FakerUtility faker = new FakerUtility();
	ExcelUtility excel = new ExcelUtility();

	@Test(dataProvider = "credentials")
	public void verify_valid_credentials() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();
		boolean isHomepageIsLoaded = loginPage.isDashboardIsLoaded();
		Assert.assertTrue(isHomepageIsLoaded,Constant.ERROR_MESSAGE_FOR_LOGIN);
	}

	@Test(groups = {"smoke"})
	@Parameters({ "username", "password" })
	public void verifyInvalidUsernameAndCorrectPassword() throws IOException {
		LoginPage1 loginpage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");
		loginpage.signIn();
		boolean isAlertIsDisplyaed  =loginpage.isAlertIsDisplayed();
		Assert.assertTrue(isAlertIsDisplyaed,Constant.ERROR_MESSAGE_FOR_LOGIN_FAILED);

	}

	@Test(groups = {"smoke"})
	public void verifyCorrectUsernameAndInvalidPassword() throws IOException {
		LoginPage1 loginpage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		loginpage.signIn();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual,Constant.ERROR_MESSAGE_FOR_LOGIN_FAILED);

	}

	@Test
	public void verifyInvalidUsernameAndPassword() throws IOException {
		LoginPage1 loginpage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		loginpage.signIn();
		boolean isAlertIsDisplyaed  =loginpage.isAlertIsDisplayed();
		Assert.assertTrue(isAlertIsDisplyaed,Constant.ERROR_MESSAGE_FOR_LOGIN_FAILED);
	}
}

