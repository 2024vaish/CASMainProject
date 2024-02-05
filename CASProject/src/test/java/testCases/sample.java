package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pageObjects.HomePage;

public class sample {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://be.cognizant.com");
	}

	@Test
	public void test() throws InterruptedException {
		
		HomePage hp= new HomePage(driver);
		hp.clickLink();
		//Thread.sleep(10);
		String s=driver.getTitle();
		System.out.println("*************asdsdcvsdfdf**********"+s);
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
