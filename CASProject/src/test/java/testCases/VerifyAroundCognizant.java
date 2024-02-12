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
import pageObjects.PageObject;
import testBase.BaseClass;

public class VerifyAroundCognizant extends BaseClass {
	HomePage hp;
	
	@Test(priority=1)
	void scroll() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		HomePage hp=new HomePage(driver);
		
	}
	
	@Test(priority=2)
	void verifyAroundCognizantPresent()
	{
		logger.info("Verifying AroundCognizant is displayed or not.");
		hp=new HomePage(driver);
		boolean text=hp.checkTextPresence();
		Assert.assertEquals(text, true,"Around cognizant is not displayed");
		
	}
	
	@Test(priority=3)
	void verifyNewsDisplayed() {
		int count=hp.headerVisible();
		Assert.assertNotEquals(count,0,"News are Displayed");

	}
	
	@Test(priority=5)
	void verifyTooltipAndHeader() {
		//=new HomePage(driver);
		boolean flag = false;
			flag=hp.tooltip();
			Assert.assertEquals(flag,true);
		}
		
	


}
