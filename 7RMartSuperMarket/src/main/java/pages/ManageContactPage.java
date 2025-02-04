package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	public WebDriver driver;
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")private WebElement actionButton;
	@FindBy(xpath="//input[@name='phone']")private WebElement enterPhone;
	@FindBy(xpath="//input[@name='email']")private WebElement enterEmail;
	@FindBy(xpath="//textarea[@name='address']")private WebElement enterAddress;
	@FindBy(xpath="//textarea[@name='del_time']")private WebElement enterDeliveryTime;
	@FindBy(xpath="//input[@name='del_limit']")private WebElement enterDeliveryLimit;
	@FindBy(xpath="//button[@name='Update']")private WebElement updateButton;
	public ManageContactPage clickActionButton() {
		actionButton.click();
		return this;
	}///////
	public ManageContactPage enterPhoneNumber(String phone) {
		enterPhone.sendKeys(phone);
		return this;
	}
	public ManageContactPage enterEmail(String email) {
		enterEmail.sendKeys(email);
		return this;
	}
	public ManageContactPage enterAddress(String address) {
		enterAddress.sendKeys(address);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String del_time) {
		enterDeliveryTime.sendKeys(del_time);
		return this;
	}
	public ManageContactPage enterDeliveryLimit(String del_limit) {
		enterDeliveryLimit.sendKeys(del_limit);
		return this;
	}
	public ManageContactPage clickUpdateButton() {
		updateButton.click();
		return this;
	}
}
