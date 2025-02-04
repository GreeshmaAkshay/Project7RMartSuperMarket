package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	public WebDriver driver;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username")private WebElement supermarketusername;
	@FindBy(name="password")private WebElement supermarketpassword;
	@FindBy(xpath="//button[@type='submit']")private WebElement signInButton;
	@FindBy(xpath="//li[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	
	public LoginPage1 enterUserName(String username) {
		supermarketusername.sendKeys(username);
		return this;
	}
	public LoginPage1 enterPassword(String password) {
		supermarketpassword.sendKeys(password);
		return this;
	}
	public HomePage signIn() {
		signInButton.click();
		return new HomePage(driver); 
	}
	public boolean isDashboardIsLoaded() {
		return dashboard.isDisplayed();
	}
	public boolean isAlertIsDisplayed() {
		return alert.isDisplayed();
	}
}
