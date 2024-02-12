package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtils;

public class HomePage extends BasePage{
	ExcelUtils eu=new ExcelUtils();
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	By click_Profile_icon=By.id("O365_MainLink_Me");//mectrl_main_trigger
	By click_name=By.id("mectrl_currentAccount_primary");
	By click_email = By.id("mectrl_currentAccount_secondary");
	String name;
	String email;
	
	@FindBy(how=How.XPATH, using="//span[@class=\"fontSizeXLarge\"]/strong")
	WebElement AroundCognizant;
	
	@FindBy(how=How.XPATH, using="//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']")
	public List<WebElement> newsLinks;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"6a300658-3c93-45bc-8746-5964a4379bbf\"]")
	WebElement untill;
	
	@FindBy(xpath="//a//strong[text()='See all']")
	WebElement seeAllLink;//=driver.findElement(By.xpath("//a//strong[text()='See all']"));
	
	@FindBy(id="O365_MainLink_Me")
	WebElement btn;//=driver.findElement(click_Profile_icon);
	
	List<String> text = new ArrayList<String>();
	
	public void getNewsLinks() {
		newsLinks=driver.findElements(By.xpath("//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']"));
		
	}
	
 	
	 
	public void clickProfileIcon() {
		hoverOverElement(btn);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(click_Profile_icon));
		js.executeScript ("arguments[0].click()",btn);
	}
	
	public List<String> getUserDetails() {
		name = driver.findElement(click_name).getText();
		email = driver.findElement(click_email).getText();
		List<String> details=new ArrayList<String>();
		details.add(name);
		details.add(email);
		System.out.println(name+"**********"+email);
		return details;
	}
	
	public boolean checkTextPresence()
	{
		scroll(AroundCognizant);
		boolean status=AroundCognizant.isDisplayed();		
		return status;
	}
	
	public int headerVisible() {
		int count=newsLinks.size();	
	    return count;  
	}

	public List<String> headerText() throws IOException {
		this.getNewsLinks();
		System.out.println("Home Page NewsLinks Count :"+newsLinks.size());
		int i=0;
		for(WebElement ele:newsLinks) {
			String s=ele.getText();
			text.add(s);
			i++;	
		}
		System.out.println("Home Page News Count :"+text.size());
		eu.writeExcel("NewsHeading", text);
		return text; 
	}
	
	
	public boolean tooltip() {
	
		String headertext;
		boolean flag=false;
		for(WebElement link:newsLinks) {
		
		scroll(link);
		hoverOverElement(link);
		headertext=link.getText();
		String tooltipText=link.getAttribute("title");
		flag=tooltipText.equals(headertext);
		if(flag==false)
			break;
		}
		return flag;
	}

	 public void clickSeeAllLink(){
		scroll(seeAllLink);
		//js.executeScript("arguments[0].scrollIntoView();", seeAllLink);
		hoverOverElement(seeAllLink);
		seeAllLink.click();
 		
		
}
}


	
	

