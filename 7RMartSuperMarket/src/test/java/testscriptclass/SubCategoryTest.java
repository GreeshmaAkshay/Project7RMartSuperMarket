package testscriptclass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage1;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base1{
	HomePage home;
	SubCategoryPage subcategory;
  @Test
  
	public void add_subcategory() throws AWTException, IOException{
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();//Login
		subcategory = home.click_SubCategory_Division();
		subcategory.select_Category().enterSubCategory("Leafy Veggies").upload_file().saveSubCategory();
		
		boolean alertMessage = loginPage.isAlertIsDisplayed();
		Assert.assertTrue(alertMessage,Constant.ERROR_MESSAGE_FOR_SUB_CATEGORY_CREATION);
	}
	
}