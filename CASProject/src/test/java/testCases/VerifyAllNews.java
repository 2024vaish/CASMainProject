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
	
	
	
	@Test(priority=1,groups= {"smoke","regression"})
	public void verifySeeAllLink() throws InterruptedException, IOException {
		Thread.sleep(5000);
		logger.info("Clickin on See All Link");
		hp= new HomePage(driver);
		l1=hp.headerText();
		captureScreen("SeeAllLink");
		hp.clickSeeAllLink();
		Thread.sleep(10);
		
	}
	
	@Test(priority=2,dataProvider="dp",groups= {"regression"})
	public void verifyNewsHeaders(String NewsHeading) throws InterruptedException {
		logger.info("Verifying News Present on Both pages");
		
		n=new  News(driver);
		l2=n.getNewsText();
			for(String s2:l2) {
				if(NewsHeading.equals(s2)) {
					System.out.println(NewsHeading+"is present on news Page");
					break;
				}
			}
				
			
			
		
}
	@Test(priority=3,groups= {"regression"})
	public void verifyEachNews() throws InterruptedException, IOException {
		logger.info("Capturing information of top 5 News");
		System.out.println("Capturing details of top 5 News of News page");
		NewsInfoPage newsInfoPage;

		for(int i=0;i<5;i++) {
			n.clickNewsHeader(i);
			newsInfoPage = new NewsInfoPage(driver);
			newsInfoPage.getNewsDetails(i);
			captureScreen("News Details"+i);
						
		}
		
	}
	
	@DataProvider(name="dp")
	String[] getNewsData() throws IOException{
		List<String> data=eu.readExcel("NewsHeading");
		return data.toArray(new String[0]);
	}
	
	
	
}
