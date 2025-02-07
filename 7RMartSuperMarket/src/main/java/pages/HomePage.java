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
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")private WebElement admin;
	@FindBy(xpath="//a[@class='dropdown-item']")private WebElement logoutButton;
	@FindBy(linkText = "admin/list-admin")private WebElement adminuser;
	@FindBy(xpath="//a[@class='small-box-footer'][8]")private WebElement manageProductMoreInfo;
	 @FindBy(xpath="//a[@class='small-box-footer'][9]")private WebElement manageNewsMoreInfo;
	 @FindBy(xpath = "(//a[@class='small-box-footer'])[3]")private WebElement footerText;
	 @FindBy(xpath = "(//a[@class='small-box-footer'])[4]")private WebElement sub_category;
	 @FindBy(xpath = "(//a[@class='small-box-footer'])[5]")private WebElement manageContactInfo;
	 
	public AdminUsers clickAdminUserDivision() { 
		 admin.click();
		 return new AdminUsers(driver);
	 }
	public ManageProductPage manageProductDivision() {
		manageProductMoreInfo.click();
		return new ManageProductPage(driver);
	}
	public ManageNewsPage click_manageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		 return new ManageNewsPage(driver);
	 }
	public FooterTextPage click_footerTextpage() {
		footerText.click();
		return new FooterTextPage(driver);
	}
	public SubCategoryPage click_SubCategory_Division() {
		sub_category.click();
		return new SubCategoryPage(driver);
	}
	public ManageContactPage click_manageContactDivision() {
		manageContactInfo.click();
		return new ManageContactPage(driver);
	}
	public LoginPage1 clickLogout() {
		admin.click();
		logoutButton.click();
		return new LoginPage1(driver);
	}
}
