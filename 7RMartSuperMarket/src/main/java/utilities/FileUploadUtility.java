package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void sendKeysForFileUpload(WebElement element, String path) {
		element.sendKeys(path);
	}
	public void roboKeysForFileUpload(WebElement element, String path) throws AWTException {
		StringSelection str_selection = new StringSelection("C:\\Users\\GREESHMA GB\\Downloads.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str_selection, null); // cpaste to clipboard
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
}
