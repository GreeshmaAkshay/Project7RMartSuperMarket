package testscriptclass;

import org.testng.annotations.Test;

import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage1;
import pages.ManageProductPage;

public class ManageProductTest extends Base1{
	HomePage home;
	AdminUsers admin;
	ManageProductPage manageProduct;
  @Test
  public void search_product() {
		LoginPage1 loginPage = new LoginPage1(driver);
		loginPage.enterUserName("admin").enterPassword("admin");
		home = loginPage.signIn();
		manageProduct=home.manageProductDivision();
		manageProduct.clickSearchButton().enterProductTitle("ayoob").enterProductCode("").selectCategory().selectSubCategory().searchProduct();
  }
}
