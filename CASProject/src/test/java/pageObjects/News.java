package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtils;

public class News extends BasePage {
	ExcelUtils obj=new ExcelUtils();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	WebElement newsTitle=driver.findElement(By.xpath("//span[contains(text(),'News')]"));
	public List<WebElement> newsLinks=driver.findElements(By.xpath("//a[@id='news_text_title']"));
	HomePage hp=new HomePage(driver);
	public News(WebDriver driver) {
		super(driver);
		
	}
	
	//newsLinks=
	public void getlist() throws InterruptedException {
		List<WebElement> totalnews=new ArrayList<>();
		newsLinks=driver.findElements(By.xpath("//a[@id='news_text_title']"));
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		while(totalnews.size()<newsLinks.size()) {
			//newsLinks=driver.findElements(By.xpath("//a[@id='news_text_title']"));
			totalnews=newsLinks;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			newsLinks=driver.findElements(By.xpath("//a[@id='news_text_title']"));
		}
		
		
		
	}
	
	public List<String> getNewsText() throws InterruptedException{
		this.getlist();
		List<String> newsHeadings=new ArrayList<String>();
		for(WebElement ele:newsLinks)
		{
			newsHeadings.add(ele.getText());
		}
		return newsHeadings;
	}
	public void clickNewsHeader(int i) throws InterruptedException {
			this.getlist();
			WebElement item=newsLinks.get(i);
			scroll(item);
			Thread.sleep(2000);
			item.click();
			
			
			
		}
		
	}



