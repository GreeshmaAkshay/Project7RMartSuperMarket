package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	
	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@class='form-control selectpicker']")private WebElement selectCategory;
	@FindBy(xpath="//input[@name='subcategory']")private WebElement subCategory;
	@FindBy(xpath="//input[@name='main_img']")private WebElement fileUpload;
	@FindBy(xpath="//button[@class='btn btn-danger']")private WebElement saveButton;
	
	public SubCategoryPage select_Category() {
		pageutility.selectByValue(selectCategory,"555");
		return this;
	}
	public SubCategoryPage enterSubCategory(String sub_Category) {
		subCategory.sendKeys(sub_Category);
		return this;
	}
	public SubCategoryPage upload_file() throws AWTException {
		FileUploadUtility file_upload_utility = new FileUploadUtility();
		file_upload_utility.roboKeysForFileUpload(fileUpload,Constant.FILE);
		return this;
	}
	public SubCategoryPage saveSubCategory() {
		saveButton.click();
		return this;
	}
}
