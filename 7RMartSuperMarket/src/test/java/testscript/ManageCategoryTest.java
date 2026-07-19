package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;

import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {
	
	HomePage homepage;
	ManageCategoryPage managecategory1;
	@Test(retryAnalyzer=retry.Retry.class,description="testcase is for managing category")
	public void ManageCategoryInformation() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		
		
		//String category=ExcelUtility.getStringData(1, 0, "managecategory");
		
		//ManageCategoryPage managecategory1 = new ManageCategoryPage(driver);
		FakerUtility faker= new FakerUtility();
		String category=faker.generateCategory();
	
		managecategory1=homepage.clickonmanagecategorymoreinfo();
		managecategory1.newbutton().entercategory(category).organic().choosefile().save();
		//managecategory1.entercategory(category);
		//managecategory1.organic();
	     //managecategory1.choosefile();
		//managecategory1.save();
		boolean alert=managecategory1.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constant.CATEGORYPAGE);
	}

}
