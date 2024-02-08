package testCases;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.UserDetails;
import pageObjects.HomePage;
import testBase.BaseClass;


public class VerifyUserDetails extends BaseClass {

	@Test(priority=1)
	void Capture() throws InterruptedException {
		hp= new HomePage(driver);
		Thread.sleep(10000);
		Map<String,String> map= new HashMap<String,String>();
		map = hp.functionality();
		boolean username=map.containsKey(p.getProperty("userName"));
		boolean email=map.containsValue(p.getProperty("email"));
		System.out.println(username+"and"+email);
		boolean flag=false;
		if(username && email)
			flag=true;
		//Assert.assertEquals(flag, true,"User Details are not correct.");
			
	}
			

}
