package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExcelUtils;

public class News extends BasePage {
	ExcelUtils obj=new ExcelUtils();
	public News(WebDriver driver) {
		super(driver);
		
	}


	WebElement newsTitle=driver.findElement(By.xpath("//span[contains(text(),'News')]"));
	public List<WebElement> newsLinks;//=driver.findElements(By.xpath("//a[@id='news_text_title']"));
	//WebElement info=driver.findElement(By.id("fa45f946-463e-428f-a84b-0bbbde09c3ba"));
	
	public void getlist() {
		newsLinks=driver.findElements(By.xpath("//a[@id='news_text_title']"));
		
	}
	
	public void writeToExcel() throws IOException {
		this.getlist();
		ExcelUtils eu=new ExcelUtils();
		List<String> newsHeadings=new ArrayList<String>();
		String text;
		for(int i=0;i<newsLinks.size();i++)
		{
			text=newsLinks.get(i).getText();
			newsHeadings.add(text);
		}
		//eu.writeExcel(newsHeadings,0);
		
	}
	
	public void clickNewsHeader(int i) throws InterruptedException {
			this.getlist();
			WebElement item=newsLinks.get(i);
			System.out.println(item.getText());
			item.click();
			Thread.sleep(10000);
			
			
		}
		
	}



