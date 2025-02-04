package testscriptclass;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage1;

public class LoginTest1 extends Base1 {
	HomePage home;

	@Test(dataProvider = "credentials")
	public void verify_valid_credentials(String username, String password) {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName(username).enterPassword(password);
		home = loginPage.signIn();
		boolean isHomepageIsLoaded = loginPage.isDashboardIsLoaded();
		Assert.assertTrue(isHomepageIsLoaded,"Dashboard is not loaded");
	}

	@DataProvider(name = "credentials")
	public Object[][] testdata() {
		Object data[][] = { { "admin", "admin" }, { "carol", "asdf" } };
		return data;
	}

	@Test(groups = {"smole"})
	@Parameters({ "username", "password" })
	public void verifyInvalidUsernameAndCorrectPassword(String username, String password) {
		LoginPage1 loginpage = new LoginPage1(driver);
		loginpage.enterUserName(username).enterPassword(password);
		loginpage.signIn();
		boolean isAlertIsDisplyaed  =loginpage.isAlertIsDisplayed();
		Assert.assertTrue(isAlertIsDisplyaed,"Login failed");

	}

	@Test(groups = {"smoke"})
	public void verifyCorrectUsernameAndInvalidPassword() {
		LoginPage1 loginpage = new LoginPage1(driver);
		loginpage.enterUserName("admin").enterPassword("123");
		loginpage.signIn();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual,"Login failed");

	}

	@Test
	public void verifyInvalidUsernameAndPassword() {
		LoginPage1 loginpage = new LoginPage1(driver);
		loginpage.enterUserName("adminss").enterPassword("123");
		loginpage.signIn();

	}
}

