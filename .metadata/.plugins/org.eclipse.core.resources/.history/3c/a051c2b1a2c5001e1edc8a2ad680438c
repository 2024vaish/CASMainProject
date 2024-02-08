package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pageObjects.*;

public class ValidateDetailNews {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://be.cognizant.com");
		
		
	}
	
	@Test
	public void clicktheSeeAllLink() {
		HomePage hp=new HomePage(driver);
		hp.clickLink();
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
