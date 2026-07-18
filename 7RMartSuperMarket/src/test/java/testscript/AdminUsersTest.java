package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class AdminUsersTest extends Base
{
	HomePage homepage;
	AdminUsersPage admin;
	@Test(retryAnalyzer=retry.Retry.class,description="testcase is for adminusers test")
	public void createAdminUserInformation() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		//loginpage.usernameandpassword(usernamevalue, passwordvalue);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		
		
	
		String adminusernamevalue=ExcelUtility.getStringData(1, 0, "adminuserspage");
		String adminpasswordvalue=ExcelUtility.getStringData(1, 1, "adminuserspage");
		String adminusertype=ExcelUtility.getStringData(1, 2, "adminuserspage");
		
		
		//FakerUtility faker= new FakerUtility();
		//String adminusernamevalue=faker.generateCategory();
		
		
		admin=homepage.clickonadminusermoreinfo();
		admin.newbutton();
		admin.enterUsername(adminusernamevalue).enterPassword(adminpasswordvalue).selectUserType(adminusertype).save();
		//admin.enterPassword(adminpasswordvalue);
		//admin.selectUserType(adminusertype);
		
		//admin.selectusertype("admin");
		//admin.save();
		boolean alert=admin.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constant.USERCREATED);
		
	
	}

}
