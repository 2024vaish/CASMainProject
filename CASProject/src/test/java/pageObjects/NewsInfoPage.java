package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

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
	
	WebElement info=driver.findElement(By.id("fa45f946-463e-428f-a84b-0bbbde09c3ba"));
	List<String> arr=new ArrayList<String>();
	
	public  void getNewsDetails(int r) throws InterruptedException, IOException {
		String infoText=info.getText();
		String titleText=title.getText();
		titles.add(titleText);
		arr.add(infoText);
		eu.writeExcel("NewsHeadings", titleText, r, 0);
		eu.writeExcel("NewsHeadings1", infoText, r, 1);
		//js.executeScript("document.body.style.zoom='0.5'");
		Thread .sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	public void writeToExcel() throws IOException {
		System.out.print(titles.size());
		eu.writeExcel("NewsHeadings", titles);
	}

}
