package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import testBase.BaseClass;

public class VerifyAroundCognizant extends BaseClass {
	HomePage hp;
		
	@Test(priority=1,groups= {"smoke"})
	void verifyAroundCognizantPresent()
	{
		logger.info("Verifying AroundCognizant is displayed or not.");
		hp=new HomePage(driver);
		boolean text=hp.checkTextPresence();
		Assert.assertEquals(text, true,"Around cognizant is not displayed");
		
	}
	
	@Test(priority=2,groups= {"smoke","regression"})
	void verifyNewsDisplayed() throws IOException {
		int count=hp.headerVisible();
		Assert.assertNotEquals(count,0,"News are Displayed");
		captureScreen("News Under AroundCognizant");

	}
	
	@Test(priority=3,groups= {"regression"})
	void verifyTooltipAndHeader() throws InterruptedException  {
		//=new HomePage(driver);
		boolean flag = false;
			flag=hp.tooltip();
			Assert.assertEquals(flag,true);
		}
		
	


}