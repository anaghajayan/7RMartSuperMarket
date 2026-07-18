package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage homepage;
	ManageNewsPage managenews1;
	@Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"},description="testcase is for managing news")
	public void manageNewsTestInformation() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		
		
		String newsinfo=ExcelUtility.getStringData(1, 0, "managenews");
		//ManageNewsPage managenews1 = new ManageNewsPage(driver);
		managenews1=homepage.clicktomanagenewsinfo();
		managenews1.newbutton().enternews(newsinfo).save();
		//managenews1.enternews(newsinfo);
		//managenews1.save();
		boolean alert=managenews1.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
		
	
	}

}
