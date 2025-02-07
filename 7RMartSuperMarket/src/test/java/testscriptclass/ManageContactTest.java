package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage1;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base1 {
	HomePage home;
	ManageContactPage contact;

	@Test
	public void verify_update_contact_details() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();// Login
		contact = home.click_manageContactDivision();
		contact.clickActionButton().enterPhoneNumber("1236547890").enterEmail("admin@gmail.com")
				.enterAddress("SJHSGDJGASFD").enterDeliveryTime("5hrs").enterDeliveryLimit("500rs").clickUpdateButton();
		
		boolean alertMessage = loginPage.isAlertIsDisplayed();
		Assert.assertTrue(alertMessage,Constant.ERROR_MESSAGE_FOR_UPDATE_CONTACT_DETAILS);
	}

	
}
