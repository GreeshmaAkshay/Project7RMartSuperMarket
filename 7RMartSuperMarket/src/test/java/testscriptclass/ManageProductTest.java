package testscriptclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage1;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base1{
	HomePage home;
	AdminUsers admin;
	ManageProductPage manageProduct;
  @Test
  public void search_product() throws IOException {
		LoginPage1 loginPage = new LoginPage1(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		home = loginPage.signIn();
		manageProduct=home.manageProductDivision();
		manageProduct.clickSearchButton().enterProductTitle("Tomato").enterProductCode("").selectCategory().selectSubCategory()
		.searchProduct();
		
		boolean alertMessage = loginPage.isAlertIsDisplayed();
		Assert.assertTrue(alertMessage,Constant.ERROR_MESSAGE_FOR_SEARCH_PRODUCT);
  }
}
