package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")WebElement alert;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}

	public void enterUsername(String usernamevalue)
	{
		
		username.sendKeys(usernamevalue);
	}
	
	public void enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	
	public void signIn()
	{
		signin.click();
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
		
	}
	
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}
	
	public void usernameandpassword(String username1,String password1)
	{
		username.sendKeys(username1);
		password.sendKeys(password1);
		signin.click();
	}


}
