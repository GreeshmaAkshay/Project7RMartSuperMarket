package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.FooterTextPage;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;

public class FooterTextTest extends Base1 {
	HomePage home;
	FooterTextPage footer;

	@Test
	public void verify_adding_footer_text() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();// Login
		footer = home.click_footerTextpage();
		footer.clickActionButton().enterAddressOnAddressField("Haritham").enterEmailOnEmailField("haritham@gmail.com")
				.enterPhoneOnPhoneField("9867543467").clickUpdateButton();
		boolean alertMessage = loginPage.isAlertIsDisplayed();
		Assert.assertTrue(alertMessage,Constant.ERROR_MESSAGE_FOR_FOOTER_TEXT);
	}

	
}
