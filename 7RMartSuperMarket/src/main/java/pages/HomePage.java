package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
public WebDriver driver;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenewsmoreinfo;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusermoreinfo;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement managecategorymoreinfo;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/add-cod'  and @class='small-box-footer']")WebElement managecodmoreinfo;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")WebElement managedeliverymoreinfo;
    
    
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;

	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}

	public ManageNewsPage clicktomanagenewsinfo()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
 		wait.until(ExpectedConditions.elementToBeClickable(managenewsmoreinfo)).click();
		return new ManageNewsPage(driver) ;
	
	}
	public AdminUsersPage clickonadminusermoreinfo()
	{
		adminusermoreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage clickonmanagecategorymoreinfo()
	{
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	public ManageCodPage clickonmanagecodmoreinfo()
	{
		managecodmoreinfo.click();
		return new ManageCodPage(driver);
	}
	public ManageDeliveryBoyPage clickonmanagedeliverymoreinfo()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
 		wait.until(ExpectedConditions.elementToBeClickable(managedeliverymoreinfo)).click();
		return new ManageDeliveryBoyPage(driver);
		
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
