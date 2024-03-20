package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import Utilities.ExcelUtils;

public class HomePage extends BasePage{
	ExcelUtils eu=new ExcelUtils();
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	
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
	WebElement seeAllLink;
	
	@FindBy(id="O365_MainLink_Me")
	WebElement profileIcon;
	
	List<String> text = new ArrayList<String>();
	
	public void getNewsLinks() {
		newsLinks=driver.findElements(By.xpath("//div[@id='6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']"));	
	}
	
 	
	public void clickProfileIcon() throws InterruptedException {
		Thread.sleep(10000);
		hoverOverElement(profileIcon);
		js.executeScript ("arguments[0].click()",profileIcon);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
	
	public List<String> getUserDetails() {
		System.out.println("*********User Details********");
		name = driver.findElement(click_name).getText();
		email = driver.findElement(click_email).getText();
		List<String> details=new ArrayList<String>();
		details.add(name);
		details.add(email);
		System.out.println("Username: "+name+"\nEmail: "+email);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		
		}
		
		return details;
	}
	
	public boolean checkTextPresence()
	{
		scroll(AroundCognizant);
		boolean status=AroundCognizant.isDisplayed();		
		return status;
	}
	
	public int headerVisible() throws IOException {
		int count=newsLinks.size();	
		return count;  
	}

	public List<String> headerText() throws IOException{
		this.getNewsLinks();
		System.out.println("**************News Present Under Around Cognizant Section*************");
		
		int i=0;
		for(WebElement ele:newsLinks) {
			String s=ele.getText();
			System.out.println(s);
			text.add(s);
			i++;	
		}
		
		eu.writeExcel("NewsHeading", text);
		return text; 
	}
	
	
	public boolean tooltip() throws InterruptedException {
		System.out.println("*********Tooltips********");
		String headertext;
		boolean flag=false;
		for(WebElement link:newsLinks){
		scroll(link);
		Thread.sleep(5000);
		hoverOverElement(link);
		headertext=link.getText();
		String tooltipText=link.getAttribute("title");
		System.out.println(tooltipText);
		flag=tooltipText.equals(headertext);
		if(flag==false)
			break;
		}
		return flag;
	}

	
	
	 public void clickSeeAllLink(){
		scroll(seeAllLink);
		hoverOverElement(seeAllLink);
		seeAllLink.click();
 		
		
}
}