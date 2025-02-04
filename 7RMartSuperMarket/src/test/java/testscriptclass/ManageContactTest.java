package testscriptclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage1;
import pages.ManageContactPage;

public class ManageContactTest extends Base1 {
	HomePage home;
	ManageContactPage contact;

	@Test(dataProvider = "credentials")
	public void admin_Logout(String username, String password) {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName(username).enterPassword(password);
		home = loginPage.signIn();// Login
		contact = home.click_manageContactDivision();
		contact.clickActionButton().enterPhoneNumber("1236547890").enterEmail("admin@gmail.com")
				.enterAddress("SJHSGDJGASFD").enterDeliveryTime("5hrs").enterDeliveryLimit("500rs").clickUpdateButton();

	}

	@DataProvider(name = "credentials")
	public Object[][] testdata() {
		Object data[][] = { { "admin", "sdasd" }, { "admin", "admin" } };
		return data;
	}
}
