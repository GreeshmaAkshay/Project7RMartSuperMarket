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
		fileUpload.click();
		StringSelection str_selection  = new StringSelection("C:\\Users\\GREESHMA GB\\Downloads.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str_selection,null);//copy to clipboard
		Robot robot = new Robot();
		//robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return this;
	}
	public SubCategoryPage saveSubCategory() {
		saveButton.click();
		return this;
	}
}
