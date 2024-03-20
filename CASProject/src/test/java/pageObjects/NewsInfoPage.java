package pageObjects;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExcelUtils;

public class NewsInfoPage extends BasePage{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public NewsInfoPage(WebDriver driver) {
		super(driver);
	}
	ExcelUtils eu=new ExcelUtils();
	
	WebElement title=driver.findElement(By.id("title_text"));
	List<String> titles=new ArrayList<String>();
	
	WebElement info=driver.findElement(By.id("spPageCanvasContent"));
	List<String> arr=new ArrayList<String>();
	
	public  void getNewsDetails(int r) throws InterruptedException, IOException {
		String infoText;
		infoText=info.getText().substring(0, 500);
		String titleText=title.getText();
		titles.add(titleText);
		arr.add(infoText);
		System.out.println(r+1+") "+titleText);
		System.out.println(infoText+"\n\n");
		eu.writeExcel("NewsHeadings", titleText, r, 0);
		eu.writeExcel("NewsHeadings1", infoText, r, 1);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.navigate().back();
//		Thread .sleep(5000);
		
	}
	
	public void writeToExcel() throws IOException {
		System.out.print(titles.size());
		eu.writeExcel("NewsHeadings", titles);
	}

}
