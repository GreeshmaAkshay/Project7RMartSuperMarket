package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage1;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base1{
	HomePage home;
	ManageNewsPage news;
  @Test
  public void create_news() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();
		news=home.click_manageNewsMoreInfo();
		news.click_newButton().enterTheNews("Rama Killed Ravana").saveNews();
		
		boolean alertMessage = loginPage.isAlertIsDisplayed();
		Assert.assertTrue(alertMessage,Constant.ERROR_MESSAGE_NEWS);
	}
}