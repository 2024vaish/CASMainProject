package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Utilities.ExcelUtils;
import pageObjects.HomePage;
import pageObjects.News;
import pageObjects.NewsInfoPage;
import testBase.BaseClass;

public class VerifyAllNews extends BaseClass{
	HomePage hp;
	News n;
	public NewsInfoPage newsInfoPage;
	ExcelUtils eu=new ExcelUtils();
	List<String>l1;
	List<String>l2;
	
	
	
	@Test(priority=1)
	public void verifySeeAllLink() throws InterruptedException, IOException {
		
		logger.info("Clickin on See All Link");
		hp= new HomePage(driver);
		l1=hp.headerText();
		hp.clickSeeAllLink();
		Thread.sleep(10);
		
	}
	
	@Test(priority=2,dataProvider="dp")
	public void verifyNewsHeaders(String NewsHeading) throws InterruptedException {
		logger.info("Verifying News Present on Both pages");
		n=new  News(driver);
		l2=n.getNewsText();
			for(String s2:l2) {
				if(NewsHeading.equals(s2))
					System.out.println(NewsHeading+" news is present on both pages");
			}
		
}
	@Test(priority=3)
	public void verifyEachNews() throws InterruptedException, IOException {
		logger.info("Capturing information of top 5 News");
		//newsInfoPage = new NewsInfoPage(driver);
		NewsInfoPage newsInfoPage;
		n.writeToExcel();
		for(int i=0;i<5;i++) {
			n.clickNewsHeader(i);
			newsInfoPage = new NewsInfoPage(driver);
			newsInfoPage.getNewsDetails(i);
			//eu.writeExcel("NewsHeadings",data,i,0);
			
		}
		
	}
	
	
	@DataProvider(name="dp")
	String[] getNewsData() throws IOException{
		List<String> data=eu.readExcel("NewsHeading");
		return data.toArray(new String[0]);
	}
	
	
	
}
