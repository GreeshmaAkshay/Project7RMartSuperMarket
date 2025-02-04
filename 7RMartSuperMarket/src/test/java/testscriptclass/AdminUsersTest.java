package testscriptclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage1;
import utilities.FakerUtility;

public class AdminUsersTest extends Base1{
	HomePage home;
	AdminUsers admin;
	FakerUtility faker;
  @Test(retryAnalyzer = retry.Retry.class)
  public void save_admin_users() {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName("admin").enterPassword("admin");
		home = loginPage.signIn();
		admin=home.clickAdminUserDivision();
		
		
		String usernameField = faker.getFakeFirstName();
		String passwordField = faker.getPassword();
		
		admin.clickNewButton().enterAdminUsername(usernameField).enterAdminPassword(passwordField).selectAdminType().saveButton();
		String expected = "https://groceryapp.uniqassosiates.com/admin/list-admin?add=1";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual,"User Created Successfully");
	}
  @Test
  public void search_admin_users() {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName("admin").enterPassword("admin");
		home = loginPage.signIn();
		admin=home.clickAdminUserDivision();
		admin.clickSearchButton().enterAdminsearchUsername("ayoob").selectType().searchButton();
		
	}
}
