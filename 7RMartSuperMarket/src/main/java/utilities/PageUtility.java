package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void selectByValue(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectByDrop(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectCategory(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectSubCategory(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void subCategorySelect(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByValue(text);
	}
	
}
