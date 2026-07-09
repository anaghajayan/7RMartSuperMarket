package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageCodPage {
public WebDriver driver;
	
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/add-cod'  and @class='small-box-footer']")WebElement managecod;
    @FindBy(xpath="//input[@type='radio']")WebElement yesbutton;
    @FindBy(xpath="//button[@name='create']")WebElement savebutton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
    
	public ManageCodPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}
	public void selectmanagecod()
	{
		managecod.click();
	}
	public void selectradiobutton()
	{
		yesbutton.click();
	}
	
	public void clickonsavebutton()
	{
		savebutton.click();
	}
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}

}
