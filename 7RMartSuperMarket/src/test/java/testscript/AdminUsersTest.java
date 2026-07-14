package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class AdminUsersTest extends Base
{
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void createAdminUserInformation() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		/*loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		*/
		loginpage.usernameandpassword(usernamevalue, passwordvalue);
		
	
		String adminusernamevalue=ExcelUtility.getStringData(1, 0, "adminuserspage");
		String adminpasswordvalue=ExcelUtility.getStringData(1, 1, "adminuserspage");
		String adminusertype=ExcelUtility.getStringData(1, 2, "adminuserspage");
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		//FakerUtility faker= new FakerUtility();
		//String adminusernamevalue=faker.generateCategory();
		
		adminuserspage.adminuser();
		adminuserspage.newbutton();
		adminuserspage.enterUsername(adminusernamevalue);
		adminuserspage.enterPassword(adminpasswordvalue);
		adminuserspage.selectUserType(adminusertype);
		
		//adminuserspage.selectusertype("admin");
		adminuserspage.save();
		boolean alert=adminuserspage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
		
	
	}

}
