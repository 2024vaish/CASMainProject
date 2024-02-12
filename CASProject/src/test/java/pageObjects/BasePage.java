package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
 WebDriver driver;
 
 	public BasePage(WebDriver driver) {
 		this.driver=driver; 
 		PageFactory.initElements(driver,this);
 		
 		
 	}
 	 
 	public void scroll(WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}
 	public void hoverOverElement(WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		 
	 }
	
}
