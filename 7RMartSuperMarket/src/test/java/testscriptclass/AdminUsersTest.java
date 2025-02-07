package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base1{
	HomePage home;
	AdminUsers admin;
	FakerUtility faker;
  @Test(retryAnalyzer = retry.Retry.class)
  public void save_admin_users() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();
		admin=home.clickAdminUserDivision();
		
		
		String usernameField = faker.getFakeFirstName();
		String passwordField = faker.getPassword();
		
		admin.clickNewButton().enterAdminUsername(usernameField).enterAdminPassword(passwordField).selectAdminType().saveButton();
		boolean statusMessage = admin.isDangerAlertIsDisplayed();
		Assert.assertEquals(statusMessage,Constant.ERROR_MESSAGE_FOR_INVALID_USER_CREATION);
	}
  @Test
  public void search_admin_users() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();
		admin=home.clickAdminUserDivision();
		String admin_username = ExcelUtility.readStringData(1, 0, "AdminPage");
		admin.clickSearchButton().enterAdminsearchUsername(admin_username).selectType().searchButton();
		boolean statusMessage = admin.isDangerAlertIsDisplayed();
		Assert.assertTrue(statusMessage, Constant.ERROR_MESSAGE_FOR_UNSUCCESSFUL_USER_SEARCH);
	}
}
