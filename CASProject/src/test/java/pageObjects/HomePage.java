package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{
	//WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By click_Profile_icon=By.id("meInitialsButton");
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
	
	public boolean checkTextPresence()
	{
		boolean status=AroundCognizant.isDisplayed();		
		return status;
	}
	public void scroll() {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", untill);
	}
	public int headerVisible() {
		int count=newsLinks.size();
	    return count;
	     
	}
	public String headerText() {
		String text = null;
		for(int i=0;i<newsLinks.size();i++) {
	    	 WebElement element=newsLinks.get(i);
	    	 text = element.getText();
	    	 }
		return text;
	}
	
	public boolean tooltip() {
	
		String headertext;
		boolean flag=false;
		for(int i=0;i<newsLinks.size();i++) {
		WebElement link=newsLinks.get(i);
		headertext=link.getText();
		String tooltipText=link.getAttribute("title");
		flag=tooltipText.equals(headertext);
		if(flag==false)
			break;
		}
		return flag;
	}
	
	public void clickLink() {
		String a=seeAllLink.getText();
		
		seeAllLink.click();
		System.out.println(a);
	}
	
}
