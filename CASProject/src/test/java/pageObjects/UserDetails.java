package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 

public class UserDetails extends BasePage{
	By click_Profile_icon=By.id("meInitialsButton");
	By click_name=By.id("mectrl_currentAccount_primary");
	By click_email = By.id("mectrl_currentAccount_secondary");
	String name;
	String email;

	public UserDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}
	
		
	
	public Map<String,String> functionality(){
		WebElement btn=driver.findElement(click_Profile_icon);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript ("arguments[0].click()",btn);
		name = driver.findElement(click_name).getText();
		email = driver.findElement(click_email).getText();
		Map<String,String> mp=new HashMap<String,String>();
		mp.put(name,email);
		System.out.println(name+"**********"+email);
		return mp;
	}
	   
	}
	

