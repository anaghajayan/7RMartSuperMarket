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
	
   // @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement managecategorymoreinfo;
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
	/*public void clickonmanagecategorymoreinfo()
	{
		managecategorymoreinfo.click();
	}*/
	public ManageCategoryPage newbutton()
	{
		newbutton.click();
		return this;
	}
	public ManageCategoryPage entercategory(String categoryvalue)
	{
		category.clear();
		category.sendKeys(categoryvalue);
		return this;
	}
	public ManageCategoryPage organic()
	{
		organic.click();
		return this;
	}
	/*PageUtility page=new PageUtility();

	public void organic()
	{
		page.doubleClick(driver, organic);
		
	}
	*/
	FileUploadUtility fileupload=new FileUploadUtility();
			
	public ManageCategoryPage choosefile() throws AWTException
	{
		//choosefile.click();
		//fileupload.fileUploadUsingRobotClass(Constant.APPLEIMG);
		fileupload.fileUploadUsingSendKeys(choosefile,Constant.APPLEIMG);
		return this;
		
	}
	public ManageCategoryPage save()
	{
		save.submit();
		return this;
	}
	
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}

	

}
