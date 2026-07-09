package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageDeliveryBoyTest extends Base {
	@Test
	public void ManageDeliveryBoy() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		
		String namevalue1=ExcelUtility.getStringData(1, 0, "adddelivery");
		String emailvalue1=ExcelUtility.getStringData(1, 1, "adddelivery");
		int phonevalue1=ExcelUtility.getIntegerData(1, 2, "adddelivery");
		String addressvalue1=ExcelUtility.getStringData(1, 3, "adddelivery");
		String usernamevaluedeli=ExcelUtility.getStringData(1, 4, "adddelivery");
		String passwordvaluedeli=ExcelUtility.getStringData(1, 5, "adddelivery");
		
		ManageDeliveryBoyPage boy = new ManageDeliveryBoyPage(driver);
		
		boy.managedelivery();
		boy.newbutton();
		boy.entername(namevalue1);
		boy.enteremail(emailvalue1);
		boy.enterphoneno(phonevalue1);
		boy.enteraddress(addressvalue1);
		boy.enterusername(usernamevaluedeli);
		boy.enterpassword(passwordvaluedeli);
		boy.savebutton();
		boolean alert=boy.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
		
		
		
	}


}
