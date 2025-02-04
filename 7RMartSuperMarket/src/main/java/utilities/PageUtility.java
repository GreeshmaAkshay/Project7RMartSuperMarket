package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void selectByValue(WebElement element,String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);
		
	}
}
