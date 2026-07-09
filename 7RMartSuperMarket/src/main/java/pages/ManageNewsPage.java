package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class ManageNewsPage {
public WebDriver driver;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement mnews;
    @FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@name='news']")WebElement news;
	@FindBy(xpath="//button[@name='create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public ManageNewsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//first one is local driver,this means current class instance driver/to initialize web elements
	}
	public void clicktomanagenews()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
 		wait.until(ExpectedConditions.elementToBeClickable(mnews)).click();
	
	}
	public void newbutton()
	{
		
		newbutton.click();
	}
	public void enternews(String newsvalue)
	{
		news.clear();
		news.sendKeys(newsvalue);
	}
	public  void save()
	{
		save.submit();
	}
	public boolean isAlertMessageDisplayed()
	{
		return alert.isDisplayed();
	}


}
