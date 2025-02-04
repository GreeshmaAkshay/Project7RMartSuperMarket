package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	 public ManageNewsPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }

	 @FindBy(xpath="//a[@class='btn btn-rounded btn-danger'][1]")private WebElement newButton;
	 @FindBy(xpath="//textarea[@class='form-control']")private WebElement enterTheNewsArea;
	 @FindBy(xpath="//button[@class='btn btn-danger']")private WebElement saveNewsButton;
	 
	 
	 public ManageNewsPage click_newButton() {
		 newButton.click();
		 return this;
	 }
	 public ManageNewsPage enterTheNews(String news) {
		 enterTheNewsArea.sendKeys(news);
		 return this;
	 }
	 public ManageNewsPage saveNews() {
		 saveNewsButton.click();
		 return this;
	 }
}
