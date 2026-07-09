package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
private static final String APPLEIMG = null;

public WebDriver driver;
	
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement managecategory;
    @FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
    @FindBy(xpath="//input[@name='category']")WebElement category;
    @FindBy(xpath="//span[text()='Organic']")WebElement organic;
    @FindBy(xpath="//input[@name='main_img']")WebElement choosefile;
    @FindBy(xpath="//button[@name='create']")WebElement save;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
    
	public ManageCategoryPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}
	public void managecategory()
	{
		managecategory.click();
	}
	public void newbutton()
	{
		newbutton.click();
	}
	public void entercategory(String categoryvalue)
	{
		category.clear();
		category.sendKeys(categoryvalue);
	}
	public void organic()
	{
		organic.click();
	}
	/*PageUtility page=new PageUtility();

	public void organic()
	{
		page.doubleClick(driver, organic);
		
	}
	*/
	FileUploadUtility fileupload=new FileUploadUtility();
			
	public void choosefile() throws AWTException
	{
		//choosefile.click();
		//fileupload.fileUploadUsingRobotClass(Constant.APPLEIMG);
		fileupload.fileUploadUsingSendKeys(choosefile,Constant.APPLEIMG);
		
	}
	public void save()
	{
		save.submit();
	}
	
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}

	

}
