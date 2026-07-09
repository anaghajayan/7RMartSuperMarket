package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
public WebDriver driver;
	
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;

	public LogoutPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}

	public void clickOnAdminButton()
	{
		admin.click();
	}
	
	public void clickOnLogoutButton()
	{
		logout.click();
	}

}
