package testCases;

import static org.testng.Assert.assertEquals;
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
	
	
	@Test(priority=1)
	void scroll() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		HomePage hp=new HomePage(driver);
		
	}
	
	@Test(priority=2)
	void testcontent()
	{
		HomePage hp=new HomePage(driver);
		boolean text=hp.checkTextPresence();
		Assert.assertEquals(text, true,"Around cognizant is not displayed");
		
	}
	
	@Test(priority=3)
	void news() {
		HomePage hp=new HomePage(driver);
		hp.headerVisible();
	}
	@Test(priority=4)
	void text() {
		HomePage hp=new HomePage(driver);
		hp.headerText();	
	}
	
	@Test(priority=5)
	void tooltips() {
		HomePage hp=new HomePage(driver);
		boolean flag = false;
			flag=hp.tooltip();
			Assert.assertEquals(flag,true);
		}
		
	
	


}
