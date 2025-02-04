package testscriptclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FooterTextPage;
import pages.HomePage;
import pages.LoginPage1;

public class FooterTextTest extends Base1 {
	HomePage home;
	FooterTextPage footer;

	@Test(dataProvider = "credentials")
	public void admin_Login(String username, String password) {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName(username).enterPassword(password);
		home = loginPage.signIn();// Login
		footer = home.click_footerTextpage();
		footer.clickActionButton().enterAddressOnAddressField("Haritham").enterEmailOnEmailField("haritham@gmail.com")
				.enterPhoneOnPhoneField("9867543467").clickUpdateButton();

	}

	@DataProvider(name = "credentials")
	public Object[][] testdata() {
		Object data[][] = { { "admin", "sdasd" }, { "admin", "admin" } };
		return data;
	}
}
