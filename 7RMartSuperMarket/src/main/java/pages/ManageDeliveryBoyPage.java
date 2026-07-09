package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageDeliveryBoyPage {
	
public WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")WebElement delivery;
    @FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@name='name']")WebElement name;
	@FindBy(xpath="//input[@name='email']")WebElement email;
	@FindBy(xpath="//input[@name='phone']")WebElement phone;
	@FindBy(xpath="//textarea[@name='address']")WebElement address;
	@FindBy(xpath="//input[@name='username']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[@name='create']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
	public ManageDeliveryBoyPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void managedelivery()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
 		wait.until(ExpectedConditions.elementToBeClickable(delivery)).click();
		//delivery.click();
	}
	public void newbutton()
	{
		newbutton.click();
	}
	public void entername(String namevalue)
	{
		name.clear();
		name.sendKeys(namevalue);
	}
	public void enteremail(String emailvalue)
	{
		email.clear();
		email.sendKeys(emailvalue);
		
	}
	public void enterphoneno(int phonevalue)
	{
		phone.clear();
		phone.sendKeys(Integer.toString(phonevalue));
	}
	public void enteraddress(String addressvalue)
	{
		address.clear();
		address.sendKeys(addressvalue);
	}
	public void enterusername(String usernamevalue)
	{
		username.clear();
		username.sendKeys(usernamevalue);
	}
	public void enterpassword(String passwordvalue)
	{
		password.clear();
		password.sendKeys(passwordvalue);
	}
	public void savebutton()
	{
		savebutton.submit();
	}
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}
}
