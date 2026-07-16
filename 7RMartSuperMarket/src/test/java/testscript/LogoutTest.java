package testscript;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;

public class LogoutTest extends Base {
	@Test
	public void verifyUserIsAbleToLogoutSuccessfullyFromDashboard()
	{
		String usernamevalue = "admin";
		String passwordvalue = "admin";

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		HomePage logoutpage= new HomePage(driver);
		logoutpage.clickOnAdminButton();
		logoutpage.clickOnLogoutButton();
	}

}
