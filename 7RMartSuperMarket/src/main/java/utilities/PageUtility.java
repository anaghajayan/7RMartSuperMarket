package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropDownVisibleText(WebElement elementname,String visibletext)
	{
		Select select=new Select(elementname);
		select.selectByVisibleText(visibletext);
	}
	
	public void dropDownValue(WebElement elementname,String value)
	{
		Select select=new Select(elementname);
		select.selectByValue(value);
	}
	
	public void dropDownIndex(WebElement elementname,int index)
	{
		Select select=new Select(elementname);
		select.deselectByIndex(index);
	}
	
	public void dragAndDrop(WebDriver driver, WebElement drag,WebElement drop)
	{
		Actions actions= new Actions(driver);
		actions.dragAndDrop(drag, drop).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement elementname)
	{
		Actions actions= new Actions(driver);
		actions.contextClick(elementname).perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement elementname)
	
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(elementname).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement elementname)
	{
		Actions actions= new Actions(driver);
		actions.doubleClick(elementname).perform();
	}
	public void click(WebDriver driver, WebElement elementname) 
	{
		Actions actions= new Actions(driver);
		actions.click(elementname).perform();
	}
	
	public void javaScriptExecutor(WebDriver driver,WebElement elementname, String value)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';", elementname,value);
	}
	
	public void pageScroll(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		
	}

}
