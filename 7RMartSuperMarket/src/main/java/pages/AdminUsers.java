package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsers {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	// Save Admin
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger'][1]")private WebElement newAdmin;
	@FindBy(xpath="//input[@id='username']")private WebElement adminUsername;
	@FindBy(xpath ="(//input[@type='password'])[1]")private WebElement adminPassword;
	@FindBy(xpath="(//select[@class='form-control'])[2]")private WebElement adminSelector;
	@FindBy(xpath ="(//button[@name='Create'])[1]")private WebElement saveButton;
//Assertion	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert1;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert2;

	//Admin Search
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement SearchfirstButton;
	@FindBy(xpath="(//input[@type='text'])[1]")private WebElement adminSearchUsername;
	@FindBy(xpath ="(//select[@class='form-control'])[1]")private WebElement adminSerchType;
	@FindBy(xpath ="(//button[@name='Search'])[1]")private WebElement SearchButton;
	
	public AdminUsers clickNewButton() {
		newAdmin.click();
		return this;
	}

	public AdminUsers enterAdminUsername(String admin_username) {
		adminUsername.sendKeys(admin_username);
		return this;
	}

	public AdminUsers enterAdminPassword(String admin_password) {
		adminPassword.sendKeys(admin_password);
		return this;
	}

	public AdminUsers selectAdminType() {
		pageutility.selectByValue(adminSelector, "db");
		return this;
	}

	public AdminUsers saveButton() {
		saveButton.click();
		return this;
	}
	
	public boolean isDangerAlertIsDisplayed() {
		return alert1.isDisplayed();
	}
	
	public boolean isSuccessAlertIsDisplayed() {
		return alert2.isDisplayed();
	}
	
	
	public AdminUsers clickSearchButton() {
		SearchfirstButton.click();
		return this;
	}
//Search
	public AdminUsers enterAdminsearchUsername(String searchUsername) {
		adminSearchUsername.sendKeys(searchUsername);
		return this;
	}
	public AdminUsers selectType() {
		pageutility.selectByValue(adminSerchType,"staff");
		return this;
	}

	public AdminUsers searchButton() {
		SearchButton.click();
		return this;
	}
}
