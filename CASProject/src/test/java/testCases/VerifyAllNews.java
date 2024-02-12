package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.News;
import pageObjects.NewsInfoPage;
import testBase.BaseClass;

public class VerifyAllNews extends BaseClass{
	HomePage hp;
	News n;
	List<String>l1;
	List<String>l2;
	@Test(priority=1)
	public void verifySeeAllLink() throws InterruptedException {
		
		logger.info("*******Starting Test Case Execution**********");
		hp= new HomePage(driver);
		l1=hp.headerText();
		hp.clickSeeAllLink();
		logger.info("Clickin on See All Link");
		Thread.sleep(10);
		
	}
	
	@Test(priority=2)
	public void verifyNewsHeaders() {
		n=new  News(driver);
		l2=n.getNewsText();
		System.out.println(l1.size()+"--------"+l2.size());
		for(String s1:l1) {
			for(String s2:l2) {
				if(s1.equals(s2))
					System.out.println(s1+" news is present on both pages");
			}
		}
}
	@Test(priority=3)
	public void verifyEachNews() throws InterruptedException, IOException {
		//News n=new News(driver);
		NewsInfoPage newsInfoPage;
		n.writeToExcel();
		for(int i=0;i<5;i++) {
			n.clickNewsHeader(i);
			newsInfoPage = new NewsInfoPage(driver);
			newsInfoPage.getNewsDetails(i);
			
		}
		
	}
	
	
	
	
}
