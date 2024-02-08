package pageObjects;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExcelUtils;

public class NewsInfoPage extends BasePage{

	public NewsInfoPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElement title=driver.findElement(By.id("title_text"));
	List<String> titles=new ArrayList<String>();
	
	WebElement info=driver.findElement(By.id("fa45f946-463e-428f-a84b-0bbbde09c3ba"));
	List<String> arr=new ArrayList<String>();
	
	public void getNewsDetails() throws InterruptedException {
		String infotext=info.getText();
		//String titleText=title.getText();
		//titles.add(titleText);
		arr.add(infotext);
		driver.navigate().back();
		Thread.sleep(10000);
	}

	
	public void writeToExcel() throws IOException {
		ExcelUtils eu=new ExcelUtils();
		eu.writeExcel(titles, 0);
		eu.writeExcel(arr,1);
	}
}
