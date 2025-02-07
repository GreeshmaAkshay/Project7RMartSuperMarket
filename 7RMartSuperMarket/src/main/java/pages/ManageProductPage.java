package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProductPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary'][1]")private WebElement searchButton;
	@FindBy(xpath="//input[@class='form-control'][1]")private WebElement productTitle;
	@FindBy(xpath="//input[@class='form-control'][2]")private WebElement productCode;
	@FindBy(xpath="//select[@class='form-control selectpicker'][1]")private WebElement selectCategory;
	@FindBy(xpath="//select[@id='sb']")private WebElement subCategory;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement productSearchButton;
	
	
	public ManageProductPage clickSearchButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToClick(driver, searchButton);
		searchButton.click();
		return this;
	}
	public ManageProductPage enterProductTitle(String title) {
		productTitle.sendKeys(title);
		return this;
	}
	public ManageProductPage enterProductCode(String code) {
		productCode.sendKeys(code);
		return this;
	}
	public ManageProductPage selectCategory() {
		Select category = new Select(selectCategory);
		category.selectByValue("555");
		return this;                                                    
	}
	public ManageProductPage selectSubCategory() {
		pageutility.selectByValue(selectCategory,"561");
		return this;                                                    
	}
	public ManageProductPage searchProduct() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementOfClickSearchButtonOfManageProduct(driver, productSearchButton);
		productSearchButton.click();
		return this;
	}
}
