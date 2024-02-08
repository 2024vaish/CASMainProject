package pageObjects;


import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class PageObject extends BasePage{
	
	//Constructor
	public PageObject(WebDriver driver)
	{
		super(driver);
	}
	
	// WebElements Locators+identification
	@FindBy(how=How.XPATH, using="//span[@class=\"fontSizeXLarge\"]/strong")
	WebElement AroundCognizant;
	@FindBy(how=How.XPATH, using="//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']")
	public List<WebElement> newsLinks;
	@FindBy(how=How.XPATH, using="//*[@id=\"6a300658-3c93-45bc-8746-5964a4379bbf\"]")
	WebElement untill;
	//Action methods
	public boolean checkTextPresence()
	{
		boolean status=AroundCognizant.isDisplayed();		
		return status;
	}
	public void scroll() {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", untill);
	}
	public int headerVisible() {
		int count=newsLinks.size();
	    return count;
	     
	}
	public String headerText() {
		String text = null;
		for(int i=0;i<newsLinks.size();i++) {
	    	 WebElement element=newsLinks.get(i);
	    	 text = element.getText();
	    	 }
		return text;
	}
	public boolean tooltip() {
	
		String headertext;
		boolean flag=false;
		for(int i=0;i<newsLinks.size();i++) {
		WebElement link=newsLinks.get(i);
		headertext=link.getText();
		String tooltipText=link.getAttribute("title");
		flag=tooltipText.equals(headertext);
		if(flag==false)
			break;
		}
		return flag;
	}
	/*
	void takeScreenshot(String xpath, String fileName)  {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.openqa.selenium.io.FileHandler.copy(screenshot, new File(".\\src\\test\\resources\\Screenshots\\"+fileName+ ".png"));
        	System.out.println("Screenshot saved: " + fileName + ".png");
        } catch (Exception e) {
            e.printStackTrace();
        }
	
	}*/
}
