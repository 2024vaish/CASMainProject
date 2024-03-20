package testCases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import testBase.BaseClass;


public class VerifyUserDetails extends BaseClass {
	List<String>details;
	@Test(priority=1,groups= {"smoke"})
	public void clickProfile() throws InterruptedException {
		logger.info("Clicking on Profile Icon");
		hp= new HomePage(driver);
		
		hp.clickProfileIcon();
		captureScreen("UserDetails");
		
	}
		
	@Test(priority=2,groups= {"regression"})
	public void verifyDetails() {
		logger.info("Verifying User Details");
		details=hp.getUserDetails();
		boolean username=details.get(0).equals(p.getProperty("UserName"));
		boolean email=details.get(1).equals(p.getProperty("email"));
		
		boolean flag=false;
		if(username && email)
			flag=true;
		//hp.clickProfileIcon();
		Assert.assertEquals(flag, true,"User Details are not correct.");
			
	}
	

}