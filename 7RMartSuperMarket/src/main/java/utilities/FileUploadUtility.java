package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement elementname, String filepath)
	{
		elementname.sendKeys(filepath);
	}
	
	public void fileUploadUsingRobotClass(String filepath) throws AWTException
	{
		StringSelection obj= new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj,null);//equal to control c
		Robot r=new Robot();//keyboard event
		r.delay(2000);
		r.keyPress(KeyEvent.VK_CONTROL);//vk control is a constant and keyEvent is control in keyboard
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}


