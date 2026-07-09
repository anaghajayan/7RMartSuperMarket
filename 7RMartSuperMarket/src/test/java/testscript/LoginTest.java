package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException 
	{
		//String usernamevalue = "admin";
		//String passwordvalue = "admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean homepage=loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage);
	
	}
	@Test
	public void  verifyUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		//String usernamevalue="admin";
		//String passwordvalue="abc123";
		String usernamevalue=ExcelUtility.getStringData(2, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
		
	}
	@Test
	public void  verifyUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		//String usernamevalue="test";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(3, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}
	@Test
	public void  verifyUserIsAbleToLoginWithInvalidUsernameAndInValidPassword() throws IOException
	{
		//String usernamevalue="test";
		//String passwordvalue="test123";
		String usernamevalue=ExcelUtility.getStringData(4, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(4, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}


}
