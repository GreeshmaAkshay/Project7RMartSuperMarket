package testscriptclass;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage1;
import pages.SubCategoryPage;

public class SubCategoryTest extends Base1{
	HomePage home;
	SubCategoryPage subcategory;
  @Test
  (dataProvider = "credentials")
	public void admin_login(String username ,String password) throws AWTException{
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName(username).enterPassword(password);
		home = loginPage.signIn();//Login
		subcategory = home.click_SubCategory_Division();
		subcategory.select_Category().enterSubCategory("Leafy Veggies").upload_file().saveSubCategory();
		
	}
	@DataProvider(name = "credentials")
	public Object[][] testdata() {
	Object data[][] = { { "admin", "sdasd" }, { "admin", "admin" } };
		return data;
	}
}