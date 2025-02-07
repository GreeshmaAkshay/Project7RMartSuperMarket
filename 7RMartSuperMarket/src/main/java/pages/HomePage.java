package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="img-circle")private WebElement admin;
	@FindBy(xpath="//a[@class='dropdown-item']")private WebElement logoutButton;
	@FindBy(linkText = "admin/list-admin")private WebElement adminuser;
	@FindBy(xpath="//a[@class='small-box-footer'][8]")private WebElement manageProductMoreInfo;
	 @FindBy(xpath="//a[@class='small-box-footer'][9]")private WebElement manageNewsMoreInfo;
	 
	public AdminUsers clickAdminUserDivision() { 
		 driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-admin");
		 return new AdminUsers(driver);
	 }
	public ManageProductPage manageProductDivision() {
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-product");
		return new ManageProductPage(driver);
	}
	public ManageNewsPage click_manageNewsMoreInfo() {
		 driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-news");
		 return new ManageNewsPage(driver);
	 }
	public FooterTextPage click_footerTextpage() {
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-footertext");
		return new FooterTextPage(driver);
	}
	public SubCategoryPage click_SubCategory_Division() {
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/Subcategory/add");
		return new SubCategoryPage(driver);
	}
	public ManageContactPage click_manageContactDivision() {
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-contact");
		return new ManageContactPage(driver);
	}
	public LoginPage1 clickLogout() {
		admin.click();
		logoutButton.click();
		return new LoginPage1(driver);
	}
}
