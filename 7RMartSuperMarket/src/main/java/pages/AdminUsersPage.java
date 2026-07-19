package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
public WebDriver driver;
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusermoreinfo;
    @FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement adminusername;
	@FindBy(xpath="//input[@id='password']")WebElement adminpassword;
	@FindBy(xpath="//select[@name='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	public AdminUsersPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}
	/*public void clickonadminusermoreinfo()
	{
		adminusermoreinfo.click();
	}*/
	public AdminUsersPage newbutton()
	{
		
		newbutton.click();
		return this;
	}
	public AdminUsersPage enterUsername(String usernamevalue)
	{
		
		adminusername.sendKeys(usernamevalue);
		return this;
	}
	
	public AdminUsersPage enterPassword(String passwordvalue)
	{
		adminpassword.sendKeys(passwordvalue);
		return this;
	}
	public AdminUsersPage selectUserType(String adminusertype)
	{
		usertype.sendKeys(adminusertype);
		return this;
	}
	PageUtility page=new PageUtility();

	/*public void selectusertype(String value)
	{
		page.dropDownValue(usertype, value);
	}
	*/
	
	public AdminUsersPage save()
	{
		save.click();
		return this;
	}
	
	
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
