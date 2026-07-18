package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageCodPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCodTest extends Base{
	HomePage homepage;
	ManageCodPage code;
	@Test(retryAnalyzer=retry.Retry.class,description="testcase is for managecode")
	public void ManageCategoryInformation() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		
		//ManageCodPage code = new ManageCodPage(driver);
		
		code=homepage.clickonmanagecodmoreinfo().selectradiobutton().clickonsavebutton();
		//code.selectradiobutton();
		//code.clickonsavebutton();
		boolean alert=code.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}


}
