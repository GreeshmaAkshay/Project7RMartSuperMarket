package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterTextPage {
	public WebDriver driver;
	public FooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")private WebElement clickActionButton;
	@FindBy(xpath="//textarea[@name='address']")private WebElement enterAddress;
	@FindBy(xpath="//input[@name='email']")private WebElement enterEmail;
	@FindBy(xpath="//input[@name='phone']")private WebElement enterPhoneNumber;
	@FindBy(xpath="//button[@name='Update']")private WebElement clickUpdate;
	
	public FooterTextPage clickActionButton() {
		clickActionButton.click();
		return this;
	}
	public FooterTextPage enterAddressOnAddressField(String address) {
		enterAddress.sendKeys(address);
		return this;
	}
	public FooterTextPage enterEmailOnEmailField(String email) {
		enterEmail.sendKeys(email);
		return this;
	}
	public FooterTextPage enterPhoneOnPhoneField(String phone) {
		enterPhoneNumber.sendKeys(phone);
		return this;
	}
	public FooterTextPage clickUpdateButton() {
		clickUpdate.click();
		return this;
		
		
		
	}
}
