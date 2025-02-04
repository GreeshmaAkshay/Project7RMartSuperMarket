package testscriptclass;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage1;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base1{
	HomePage home;
	ManageNewsPage news;
  @Test
  public void search_admin_users() {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName("admin").enterPassword("admin");
		home = loginPage.signIn();
		news=home.click_manageNewsMoreInfo();
		news.click_newButton().enterTheNews("Rama Killed Ravana").saveNews();
		
	}
}